package com.suchtool.nacosopenapi.api.vo;

import lombok.Data;

@Data
public class LoginVO {
    private String accessToken;

    private Integer tokenTtl;

    private Boolean globalAdmin;

    private String username;

}