package com.suchtool.nacosopenapi.api.bo;

import lombok.Data;

@Data
public class CommonPageBO {
    private Integer pageNo;

    private Integer pageSize = 10;
}
