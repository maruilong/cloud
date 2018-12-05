package com.xinyuan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author liang
 */
@Configuration
/**
 * 此注解开使用STOMP协议来传输基于消息代理的消息，此时可以在@Controller类中使用@MessageMapping
 */
@EnableWebSocketMessageBroker
public class WebSocketRabbitMQMessageBrokerConfigurer extends AbstractWebSocketMessageBrokerConfigurer {

    private static long HEART_BEAT = 10000;

    /**
     * 注册STOMP协议的节点(endpoint),并映射指定的url
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个STOMP的endpoint,并指定使用SockJS协议
        registry.addEndpoint("/message-test").setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置消息代理(Message Broker)
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //设置简单的消息代理器，它使用Memory（内存）作为消息代理器，
        //其中/user和/topic都是我们发送到前台的数据前缀。前端必须订阅以/user开始的消息（.subscribe()进行监听）。
        //setHeartbeatValue设置后台向前台发送的心跳，
        //注意：setHeartbeatValue这个不能单独设置，不然不起作用，要配合后面setTaskScheduler才可以生效。
        //对应的解决方法的网址：https://stackoverflow.com/questions/39220647/spring-stomp-over-websockets-not-scheduling-heartbeats
        //点对点应配置一个/user消息代理，广播式应配置一个/topic消息代理,群发（mass），单独聊天（alone）

        ThreadPoolTaskScheduler te = new ThreadPoolTaskScheduler();
        te.setThreadNamePrefix("wss-heartbeat-thread");
        te.setPoolSize(1);
        te.initialize();
        registry.enableSimpleBroker("/topic", "/user", "/mass", "/alone", "/notice").setHeartbeatValue(new long[]{HEART_BEAT, HEART_BEAT}).setTaskScheduler(te);
        //点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        registry.setUserDestinationPrefix("/user");
    }
}
