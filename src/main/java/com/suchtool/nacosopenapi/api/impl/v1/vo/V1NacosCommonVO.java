package com.suchtool.nacosopenapi.api.impl.v1.vo;

import lombok.Data;

@Data
public class V1NacosCommonVO<T> {
    private String code;

    private Object message;

    private T data;

}
