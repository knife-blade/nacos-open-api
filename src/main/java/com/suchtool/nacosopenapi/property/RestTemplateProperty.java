package com.suchtool.nacosopenapi.property;

import lombok.Data;

import java.time.Duration;

@Data
public class RestTemplateProperty {
    private Duration connectTimeout = Duration.ofSeconds(30);

    private Duration readTimeout = Duration.ofSeconds(30);

    private Boolean debug = false;
}
