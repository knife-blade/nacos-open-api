package com.suchtool.nacosopenapi.api.impl.v1.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class V1NacosInstanceVO {
    private Integer count;

    @JsonProperty("list")
    private List<InstanceVO> instanceVOList;

    @Data
    public static class InstanceVO {
        private String instanceId;

        private String ip;

        private Integer port;

        private BigDecimal weight;

        private Boolean healthy;

        private Boolean enabled;

        private Boolean ephemeral;

        private String clusterName;

        private String serviceName;

        private Metadata metadata;

        private Integer instanceHeartBeatInterval;

        private Integer instanceHeartBeatTimeOut;

        private Integer ipDeleteTimeout;

    }

    @Data
    public static class Metadata {
        @JsonProperty("preserved.register.source")
        private String preservedRegisterSource;
    }

}