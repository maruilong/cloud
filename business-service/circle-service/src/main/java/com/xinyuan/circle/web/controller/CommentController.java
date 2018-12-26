package com.xinyuan.circle.web.controller;

import com.xinyuan.base.common.util.ResultUtil;
import com.xinyuan.base.common.web.Message;
import com.xinyuan.base.common.web.PageBody;
import com.xinyuan.circle.entity.mysql.Comment;
import com.xinyuan.circle.service.CommentService;
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
@Api(description = "评论管理")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService ;

    @ApiOperation(value = "新增评论", notes = "新增评论")
    @ApiImplicitParam(name = "comment", value = "comment", required = true, dataType = "Comment")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Comment> add(@RequestBody Comment comment){

        commentService.saveComment(comment);

        return ResponseEntity.ok(comment);
    }

    @ApiOperation(value = "删除评论", notes = "删除评论")
    @ApiImplicitParam(name = "ids", value = "评论ID", required = true, dataType = "List")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Message> delete(@RequestBody List<Long> ids) {

        commentService.removeComment(ids);
        Message message = ResultUtil.success();
        return ResponseEntity.ok(message);
    }

    @ApiOperation(value = "更新评论信息", notes = "更新评论信息")
    @ApiImplicitParam(name = "comment", value = "comment", required = true, dataType = "Comment")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Message> update(@RequestBody Comment comment) {
        commentService.update(comment);

        Message message = ResultUtil.success();
        return ResponseEntity.ok(message);
    }

    @ApiOperation(value = "条件查询", notes = "条件查询")
    @ApiImplicitParam(name = "pageBody", value = "pageBody", required = false, dataType = "PageBody")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Page<Comment>> query(@RequestBody PageBody pageBody) {
        Page<Comment> page = null;

        try {
            page = commentService.query(pageBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(page);
    }

}
