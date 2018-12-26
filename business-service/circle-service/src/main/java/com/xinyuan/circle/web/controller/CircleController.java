package com.xinyuan.circle.web.controller;

import com.xinyuan.base.common.util.ResultUtil;
import com.xinyuan.base.common.web.Message;
import com.xinyuan.base.common.web.PageBody;
import com.xinyuan.circle.entity.mysql.Circle;
import com.xinyuan.circle.service.CircleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hwz
 * @Date: Created in 15:15 2018/4/10.
 */
@Api(description = "话题种类管理")
@RestController
@RequestMapping("/circle")
public class CircleController {

    @Autowired
    private CircleService circleService ;

    @ApiOperation(value = "新增圈子", notes = "新增圈子")
    @ApiImplicitParam(name = "circle", value = "circle", required = true, dataType = "Circle")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Circle> add(@RequestBody Circle circle){

        circleService.save(circle);

        return ResponseEntity.ok(circle);
    }

    @ApiOperation(value = "删除圈子", notes = "删除圈子")
    @ApiImplicitParam(name = "ids", value = "圈子ID", required = true, dataType = "List")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Message> delete(@RequestBody List<Long> ids) {

        circleService.removeCircle(ids);
        Message message = ResultUtil.success();
        return ResponseEntity.ok(message);
    }

    @ApiOperation(value = "更新圈子信息", notes = "更新圈子信息")
    @ApiImplicitParam(name = "circle", value = "circle", required = true, dataType = "Circle")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Message> update(@RequestBody Circle circle) {
        circleService.update(circle);

        Message message = ResultUtil.success();
        return ResponseEntity.ok(message);
    }

    @ApiOperation(value = "条件查询", notes = "条件查询")
    @ApiImplicitParam(name = "pageBody", value = "pageBody", required = false, dataType = "PageBody")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Page<Circle>> query(@RequestBody PageBody pageBody) {
        Page<Circle> page = null;
        try {
            page = circleService.query(pageBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(page);
    }

}
