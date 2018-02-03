package com.taotao.manager.aspect;

import com.taotao.core.enums.common.ExceptionEnum;
import com.taotao.core.exception.common.ServiceException;
import com.taotao.core.pojo.common.Result;
import com.taotao.core.util.common.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

  private static final  Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

  /**
   * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
   * @param e
   * @return
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result exceptionGet(Exception e){
      if(e instanceof ServiceException){
          ServiceException MyException = (ServiceException) e;
          return ResultUtil.error(MyException.getCode(),MyException.getMessage());
      }

      LOGGER.error("【系统异常】{}",e);
      return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
  }
}