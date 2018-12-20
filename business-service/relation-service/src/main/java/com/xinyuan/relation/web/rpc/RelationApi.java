package com.xinyuan.relation.web.rpc;

import com.xinyuan.relation.client.RelationClient;
import com.xinyuan.relation.entity.Relation;
import com.xinyuan.relation.model.dto.RelationDTO;
import com.xinyuan.relation.service.RelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Api(value = "API - MdcAddressQueryFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RelationApi implements RelationClient {

    @Autowired
    private RelationService relationService;

    @Override
    @ApiOperation(httpMethod = "POST", value = "添加关系")
    public ResponseEntity<RelationDTO> add(@RequestBody RelationDTO relationDTO) {

        Relation relation = new Relation();
        BeanUtils.copyProperties(relationDTO, relation);
        relationService.save(relation);
        return ResponseEntity.ok(relationDTO);
    }
}
