package com.xinyuan.relation.web.controller;

import com.xinyuan.relation.entity.Relation;
import com.xinyuan.relation.service.RelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: hwz
 * @Date: Created in 15:15 2018/4/10.
 */
@Api(description = "关系管理")
@RestController
@RequestMapping("/relation")
public class RelationController {

    @Autowired
    private RelationService relationService;

    @ApiImplicitParam(name = "relation", value = "relation", required = true, dataType = "RelationDTO")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Relation> add(@RequestBody Relation relation) {

        relationService.save(relation);

        return ResponseEntity.ok(relation);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<String> add() {

        return ResponseEntity.ok("relation test 接口");
    }
}
