package com.xinyuan.circle.web.controller;

import com.xinyuan.base.common.util.ResultUtil;
import com.xinyuan.base.common.web.Message;
import com.xinyuan.base.common.web.PageBody;
import com.xinyuan.circle.entity.mysql.Answer;
import com.xinyuan.circle.service.AnswerService;
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
@Api(description = "回答管理")
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService ;

    @ApiOperation(value = "新增回答", notes = "新增回答")
    @ApiImplicitParam(name = "answer", value = "answer", required = true, dataType = "Answer")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Answer> add(@RequestBody Answer answer){

        answerService.saveAnswer(answer);

        return ResponseEntity.ok(answer);
    }

    @ApiOperation(value = "删除回答", notes = "删除回答")
    @ApiImplicitParam(name = "ids", value = "回答ID", required = true, dataType = "List")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Message> delete(@RequestBody List<Long> ids) {

        answerService.removeAnswer(ids);
        Message message = ResultUtil.success();
        return ResponseEntity.ok(message);
    }

    @ApiOperation(value = "更新回答信息", notes = "更新回答信息")
    @ApiImplicitParam(name = "answer", value = "answer", required = true, dataType = "Answer")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Message> update(@RequestBody Answer answer) {
        answerService.update(answer);

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
    public ResponseEntity<Page<Answer>> query(@RequestBody PageBody pageBody) {
        Page<Answer> page = null;

        try {
            page = answerService.query(pageBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(page);
    }


    @ApiOperation(value = "回答展示", notes = "回答展示页面")
    @ApiImplicitParam(name = "pageBody", value = "pageBody", required = false, dataType = "PageBody")
    @RequestMapping(value = "/answerShow", method = RequestMethod.POST)
    public ResponseEntity<Page<Answer>> answerShow(@RequestBody PageBody pageBody) {
        Page<Answer> page = null;
        try {
            page = answerService.query(pageBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(page);
    }

}
