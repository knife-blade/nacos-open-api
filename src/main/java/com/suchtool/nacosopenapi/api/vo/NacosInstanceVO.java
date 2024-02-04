package com.suchtool.nacosopenapi.api.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NacosInstanceVO {
    private String instanceId;

    private String ip;

    private Integer port;

    private BigDecimal weight;

    private Boolean healthy;

    private Boolean enabled;

    private Boolean ephemeral;

    private String clusterName;

    private String serviceName;

    private Integer instanceHeartBeatInterval;

    private Integer instanceHeartBeatTimeOut;

    private Integer ipDeleteTimeout;

}