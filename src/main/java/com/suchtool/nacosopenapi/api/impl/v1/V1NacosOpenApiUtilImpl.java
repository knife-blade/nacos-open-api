package com.suchtool.nacosopenapi.api.impl.v1;

import com.suchtool.nacosopenapi.api.NacosOpenApiUtil;
import com.suchtool.nacosopenapi.api.bo.NacosInstancePageBO;
import com.suchtool.nacosopenapi.api.bo.NacosLoginBO;
import com.suchtool.nacosopenapi.api.bo.NacosServicePageBO;
import com.suchtool.nacosopenapi.api.vo.NacosInstanceVO;
import com.suchtool.nacosopenapi.api.vo.NacosLoginVO;
import com.suchtool.nacosopenapi.api.vo.NacosNamespaceVO;
import com.suchtool.nacosopenapi.api.vo.NacosServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class V1NacosOpenApiUtilImpl implements NacosOpenApiUtil {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public NacosLoginVO login(NacosLoginBO nacosLoginBO) {
        return null;
    }

    @Override
    public List<NacosNamespaceVO> queryAllNamespace() {
        return null;
    }

    @Override
    public List<NacosServiceVO> queryService(NacosServicePageBO nacosServicePageBO) {
        return null;
    }

    @Override
    public List<NacosInstanceVO> queryInstance(NacosInstancePageBO nacosInstancePageBO) {
        return null;
    }
}
