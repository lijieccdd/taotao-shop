package com.taotao.core.pojo.common;

import java.io.Serializable;

/**
 * 公共Model类  所有model都继承该类
 */
public class BaseModel implements Serializable {
    private Integer page;
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
