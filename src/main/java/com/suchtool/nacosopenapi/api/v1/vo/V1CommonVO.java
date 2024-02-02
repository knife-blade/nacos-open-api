package com.suchtool.nacosopenapi.api.v1.vo;

import lombok.Data;

@Data
public class V1CommonVO<T> {
    private String code;

    private Object message;

    private T data;

}
