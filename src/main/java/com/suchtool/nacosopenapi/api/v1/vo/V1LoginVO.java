package com.suchtool.nacosopenapi.api.v1.vo;

import lombok.Data;

@Data
public class V1LoginVO {
    private String accessToken;

    private Integer tokenTtl;

    private Boolean globalAdmin;

    private String username;

}