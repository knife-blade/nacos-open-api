package com.suchtool.nacosopenapi.api.vo;

import lombok.Data;

@Data
public class NacosCommonVO<T> {
    private String code;

    private Object message;

    private T data;

}
