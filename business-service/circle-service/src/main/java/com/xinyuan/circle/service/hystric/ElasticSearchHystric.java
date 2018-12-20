package com.xinyuan.circle.service.hystric;

import com.xinyuan.circle.service.ElasticSearchService;
import com.xinyuan.elasticsearch.AddDataDTO;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchHystric implements ElasticSearchService {
    @Override
    public String addData(AddDataDTO addDataDTO) {
        System.out.println(addDataDTO);
        System.out.println("-0------失败");
        return null;
    }
}
