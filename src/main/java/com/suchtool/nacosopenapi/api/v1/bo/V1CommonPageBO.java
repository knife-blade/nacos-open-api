package com.suchtool.nacosopenapi.api.v1.bo;

import lombok.Data;

@Data
public class V1CommonPageBO {
    private Integer pageNo;

    private Integer pageSize = 10;
}
