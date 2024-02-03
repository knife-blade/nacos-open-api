package com.suchtool.nacosopenapi.api.impl.v1.bo;

import lombok.Data;

@Data
public class V1NacosCommonPageBO {
    private Integer pageNo = 1;

    private Integer pageSize = 10;
}
