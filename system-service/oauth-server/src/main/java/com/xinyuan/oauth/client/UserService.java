package com.xinyuan.oauth.client;

import com.xinyuan.circle.config.security.FeignHeaderInterceptor;
import com.xinyuan.user.client.UserClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: hwz
 * @Date: Created in 16:53 2018/11/27.
 */
@FeignClient(value = "user-service", configuration = FeignHeaderInterceptor.class)
public interface UserService extends UserClient {
}
