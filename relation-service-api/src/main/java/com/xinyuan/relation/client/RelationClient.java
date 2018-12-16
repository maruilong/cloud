package com.xinyuan.relation.client;

import com.xinyuan.relation.model.dto.RelationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author liang
 */

public interface RelationClient {

    @RequestMapping(value = "/api/relation/add", method = RequestMethod.POST)
    ResponseEntity<RelationDTO> add(@RequestBody RelationDTO relationDTO);
}
