package com.xinyuan.user.client;

import com.xinyuan.user.model.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author liang
 */

public interface UserClient {

    @RequestMapping(value = "/api/user/findByUserName", method = RequestMethod.GET)
    UserDTO findByUserName(@RequestParam String username);
}
