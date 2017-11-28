package com.taotao.common.dao;

public interface RedisDAO {
    void set(String key, String value);
    String get(String key);
}
