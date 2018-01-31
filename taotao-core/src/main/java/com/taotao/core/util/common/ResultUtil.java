package com.taotao.core.util.common;

import com.taotao.core.enums.common.ExceptionEnum;
import com.taotao.core.pojo.common.Result;

public class ResultUtil {

    /**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(ExceptionEnum.SUCCESS.getCode());
        result.setMsg(ExceptionEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static Result error(String code,String msg){
        Result result = new Result();
        result.setStatus(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    public static Result error(ExceptionEnum exceptionEnum){
        Result result = new Result();
        result.setStatus(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
}