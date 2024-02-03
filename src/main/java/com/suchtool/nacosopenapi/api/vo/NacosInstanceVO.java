package com.suchtool.nacosopenapi.api.vo;

import lombok.Data;

@Data
public class NacosInstanceVO {
    private Long instanceId;

    private String ip;

    private Integer port;

    private Integer weight;

    private Boolean healthy;

    private Boolean enabled;

    private Boolean ephemeral;

    private String clusterName;

    private String serviceName;

    private Integer instanceHeartBeatInterval;

    private Integer instanceHeartBeatTimeOut;

    private Integer ipDeleteTimeout;

}