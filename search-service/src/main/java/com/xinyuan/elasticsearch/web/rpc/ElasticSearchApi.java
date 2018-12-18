package com.xinyuan.elasticsearch.web.rpc;

import com.alibaba.fastjson.JSONObject;
import com.xinyuan.elasticsearch.AddDataDTO;
import com.xinyuan.elasticsearch.common.util.elasticsearch.ElasticsearchUtil;
import com.xinyuan.elasticsearch.client.ElasticSearchClient;
import io.swagger.annotations.Api;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Api(value = "API - ElasticSearchFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ElasticSearchApi implements ElasticSearchClient {

    @Override
    public String addData(AddDataDTO addDataDTO) {
        return ElasticsearchUtil.addData(addDataDTO.getJsonObject(), addDataDTO.getIndex(), addDataDTO.getType());
    }
}
