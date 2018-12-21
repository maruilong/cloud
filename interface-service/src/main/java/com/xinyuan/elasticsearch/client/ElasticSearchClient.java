package com.xinyuan.elasticsearch.client;

import com.xinyuan.elasticsearch.AddDataDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ElasticSearchClient {

    @RequestMapping(value = "/api/elasticsearch/addData", method = RequestMethod.POST)
    String addData(@RequestBody AddDataDTO addDataDTO);

}
