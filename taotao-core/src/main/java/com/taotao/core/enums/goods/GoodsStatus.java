package com.taotao.core.enums.goods;

/**
 * @Author : lijie
 * @Description : 商品状态
 * @Date : Create in 2018/1/31 16:57
 * @Modified by :
 */
public enum GoodsStatus {
    NORMAL(1,"正常"),
    OFFSALE(2,"下架"),
    DELETE(3,"删除"),
    ;
    private Integer code;
    private String desc;

    GoodsStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
