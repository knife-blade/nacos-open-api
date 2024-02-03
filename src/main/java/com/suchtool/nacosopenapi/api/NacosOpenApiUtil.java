package com.suchtool.nacosopenapi.api;

import com.suchtool.nacosopenapi.api.bo.NacosInstancePageBO;
import com.suchtool.nacosopenapi.api.bo.NacosLoginBO;
import com.suchtool.nacosopenapi.api.bo.NacosServicePageBO;
import com.suchtool.nacosopenapi.api.vo.NacosInstanceVO;
import com.suchtool.nacosopenapi.api.vo.NacosLoginVO;
import com.suchtool.nacosopenapi.api.vo.NacosNamespaceVO;
import com.suchtool.nacosopenapi.api.vo.NacosServiceVO;

import java.util.List;

public interface NacosOpenApiUtil {
    NacosLoginVO login(NacosLoginBO nacosLoginBO);

    List<NacosNamespaceVO> queryAllNamespace();

    List<NacosServiceVO> queryService(NacosServicePageBO nacosServicePageBO);

    List<NacosInstanceVO> queryInstance(NacosInstancePageBO nacosInstancePageBO);
}
