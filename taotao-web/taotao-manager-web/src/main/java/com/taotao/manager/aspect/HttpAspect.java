package com.taotao.manager.aspect;

import com.taotao.core.enums.common.ExceptionEnum;
import com.taotao.core.exception.common.ServiceException;
import com.taotao.core.util.common.ResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    /*@Autowired
    private ExceptionHandle exceptionHandle;*/

    @Pointcut("execution(public * com.taotao.manager.controller..*.*(..))")
    public void controllerMethods(){}

    @Before("controllerMethods()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        LOGGER.info("url={}",request.getRequestURL());
        //method
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("ip={}",request.getRemoteAddr());
        //class_method
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @Around("controllerMethods()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            if(e instanceof ServiceException){
                ServiceException MyException = (ServiceException) e;
                return ResultUtil.error(MyException.getCode(),MyException.getMessage());
            }

            LOGGER.error("【系统异常】{}",e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }

        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        LOGGER.info("方法:{},执行耗时：{} ms",joinPoint.getSignature().getDeclaringTypeName()+"#"+joinPoint.getSignature().getName(),endTime-startTime);
        return obj;
    }


    @AfterReturning(pointcut = "controllerMethods()",returning = "object")//打印输出结果
    public void doAfterReturing(Object object){
        if (object!=null){
            LOGGER.info("response={}",object.toString());
        }
    }
}
