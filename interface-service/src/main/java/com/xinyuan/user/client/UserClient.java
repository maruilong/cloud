package com.xinyuan.user.client;

import com.xinyuan.user.model.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author liang
 */

public interface UserClient {

    @RequestMapping(value = "/api/user/findByUserName", method = RequestMethod.GET)
    UserDTO findByUserName(@RequestParam(value = "username", required = true) String username);

    @RequestMapping(value = "/api/user/findRoles", method = RequestMethod.GET)
    List<String> findRoles(@RequestParam(value = "id", required = true) Long id);
}
