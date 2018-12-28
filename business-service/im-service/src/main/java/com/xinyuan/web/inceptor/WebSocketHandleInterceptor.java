package com.xinyuan.web.inceptor;

import com.sun.security.auth.UserPrincipal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.security.Principal;

public class WebSocketHandleInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            String username = accessor.getFirstNativeHeader("username");
            if (StringUtils.isEmpty(username)) {
                return null;
            }
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            // 绑定user
            Principal principal = new UserPrincipal(username);
            accessor.setUser(principal);
        }
        return message;
    }
}
