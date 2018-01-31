package com.taotao.core.exception.common;

import com.taotao.core.enums.common.ExceptionEnum;

/**
 * @Author : lijie
 * @Description :服务层异常类
 * @Date : Create in 2018/1/31 11:15
 * @Modified by :
 */
public class ServiceException extends  RuntimeException{
    private String code;

    public ServiceException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
