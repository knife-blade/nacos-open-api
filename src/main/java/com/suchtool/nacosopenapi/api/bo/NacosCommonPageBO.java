package com.suchtool.nacosopenapi.api.bo;

import lombok.Data;

@Data
public class NacosCommonPageBO {
    private Integer pageNo;

    private Integer pageSize = 10;
}
