package com.taotao.core.enums.common;

import java.io.Serializable;

public enum ExceptionEnum implements Serializable{
    //错误码前两位：模块 01-系统错误 02-公共模块 03-用户模块 04-商品 05-订单 06-店铺 07-内容
    SUCCESS("000000","操作成功"),
    UNKNOW_ERROR("010001","未知错误"),
    PARAM_ERROR("020001","参数错误"),
    USER_NOT_FIND("030001","用户不存在"),
    CONTENTCAT_DEL_ERR1("070001","父节点不允许删除,请先删除子节点"),
    CONTENTCAT_DEL_ERR2("070002","该节点不存在，请刷新列表重试"),
    ;
    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}