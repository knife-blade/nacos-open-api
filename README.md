# nacos-open-api

## 1.介绍
封装Nacos的Open Api。

Nacos官方API地址：https://nacos.io/docs/v2/guide/user/open-api/

## 2.快速使用

### 1.引入依赖
```xml
<dependency>
    <groupId>com.suchtool</groupId>
    <artifactId>nacos-open-api-spring-boot-starter</artifactId>
    <version>{newest-version}</version>
</dependency>
```

### 2.配置Nacos服务端信息

略

### 3.使用

注入NacosOpenApiUtil，即可使用。例如：

```
import com.suchtool.nacosopenapi.api.NacosOpenApiUtil;
import com.suchtool.nacosopenapi.api.bo.NacosServicePageBO;
import com.suchtool.nacosopenapi.api.vo.NacosServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NacosApplicationInfoServiceImpl {
    @Autowired
    private NacosOpenApiUtil nacosOpenApiUtil;

    public void findAllApplications() {
        NacosServicePageBO nacosServicePageBO = new NacosServicePageBO();
        nacosServicePageBO.setNamespaceId("namespace1");
        nacosServicePageBO.setPageNo(1);
        nacosServicePageBO.setPageSize(100);

        List<NacosServiceVO> serviceVOS = nacosOpenApiUtil.queryService(nacosServicePageBO);
    }
}
```
