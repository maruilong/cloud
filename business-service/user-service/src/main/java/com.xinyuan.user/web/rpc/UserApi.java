package com.xinyuan.user.web.rpc;

import com.xinyuan.user.client.UserClient;
import com.xinyuan.user.entity.User;
import com.xinyuan.user.model.dto.UserDTO;
import com.xinyuan.user.service.UserRoleService;
import com.xinyuan.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@Api(value = "API - UserFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserApi implements UserClient {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
//    @ApiOperation(httpMethod = "GET", value = "根据id获取role")
    public List<String> findRoles(@RequestParam(value = "id", required = true) Long id) {
        List<String> roles = userRoleService.findRoles(id);
        return roles;
    }

    @Override
//    @ApiOperation(httpMethod = "GET", value = "根据用户名获取用户")
    public UserDTO findByUserName(@RequestParam(value = "username", required = true) String username) {
        UserDTO userDTO = new UserDTO();
        User user = userService.findByUsername(username);
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }
}
