package com.xinyuan.circle.web.controller;

import com.xinyuan.base.common.util.ResultUtil;
import com.xinyuan.base.common.web.Message;
import com.xinyuan.base.common.web.PageBody;
import com.xinyuan.circle.entity.mysql.Topic;
import com.xinyuan.circle.service.TopicService;
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
@Api(description = "话题管理")
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "新增话题", notes = "新增话题")
    @ApiImplicitParam(name = "topic", value = "topic", required = true, dataType = "Topic")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Topic> add(@RequestBody Topic topic) {

        topicService.saveTopic(topic);

        return ResponseEntity.ok(topic);
    }

    @ApiOperation(value = "删除话题", notes = "删除话题")
    @ApiImplicitParam(name = "ids", value = "话题ID", required = true, dataType = "List")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Message> delete(@RequestBody List<Long> ids) {

        topicService.removeTopic(ids);

        Message message = ResultUtil.success();
        return ResponseEntity.ok(message);
    }

    @ApiOperation(value = "更新话题", notes = "更新话题")
    @ApiImplicitParam(name = "topic", value = "topic", required = true, dataType = "Topic")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Message> update(@RequestBody Topic topic) {
        topicService.update(topic);

        Message message = ResultUtil.success();
        return ResponseEntity.ok(message);
    }

    /**
     * 条件查询
     *
     * @param pageBody
     * @return
     */
    @ApiOperation(value = "条件查询", notes = "条件查询")
    @ApiImplicitParam(name = "pageBody", value = "pageBody", required = false, dataType = "PageBody")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Page<Topic>> query(@RequestBody PageBody pageBody) {
        Page<Topic> page = null;

        try {

            page = topicService.query(pageBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(page);
    }

    @RequestMapping("test")
    public String test() {
        return "test";
    }

}
