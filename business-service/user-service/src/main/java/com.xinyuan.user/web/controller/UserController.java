package com.xinyuan.user.web.controller;

import com.xinyuan.base.common.util.ResultUtil;
import com.xinyuan.base.common.web.Message;
import com.xinyuan.base.common.web.PageBody;
import com.xinyuan.user.entity.User;
import com.xinyuan.user.service.UserService;
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
 * @author liang
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增", notes = "新增")
    @ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Message> save(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(ResultUtil.success());
    }

    @ApiOperation(value = "更新", notes = "更新")
    @ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Message> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(ResultUtil.success());
    }

    @ApiOperation(value = "删除", notes = "删除")
    @ApiImplicitParam(name = "ids", value = "ids", required = true, dataType = "List")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Message> delete(@RequestBody List<Long> ids) {
        try {
            userService.removeUser(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(ResultUtil.success());
    }

    @ApiOperation(value = "条件查询", notes = "条件查询")
    @ApiImplicitParam(name = "pageBody", value = "pageBody", required = false, dataType = "PageBody")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Page<User>> query(@RequestBody PageBody pageBody) {
        Page<User> page = null;
        try {
            page = userService.query(pageBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(page);
    }
}
