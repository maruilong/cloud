package com.xinyuan.web.config.webSocket;

import com.xinyuan.web.inceptor.MyChannelInterceptorAdapter;
import com.xinyuan.web.inceptor.MyHandShakeInterceptor;
import com.xinyuan.web.inceptor.WebSocketHandleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author liang
 * 在webSocket连接成功先后我可以做的操作
 * 此注解表示使用STOMP协议来传输基于消息代理的消息，此时可以在@Controller类中使用@MessageMapping
 */
@Component
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageBrokerConfigurerImpl implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private MyHandShakeInterceptor handShakeInterceptor;

    @Autowired
    private MyChannelInterceptorAdapter channelInterceptorAdapter;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * 注册 Stomp的端点
         * addEndpoint：添加STOMP协议的端点。这个HTTP URL是供WebSocket或SockJS客户端访问的地址
         * withSockJS：指定端点使用SockJS协议
         */
        registry.addEndpoint("/websocket-rabbitmq")
                // 添加允许跨域访问
                .setAllowedOrigins("*")
                .withSockJS();
//                .setInterceptors(handShakeInterceptor);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * queue会被轮流消费 并且会自动创建
         * exchange都会被接收
         * /amq/queue会被轮流接收 不过不会自动创建,
         * 使用RabbitMQ做为消息代理，替换默认的Simple Broker
         */
        registry
                // "STOMP broker relay"处理所有消息将消息发送到外部的消息代理
                .enableStompBrokerRelay("/exchange", "/topic", "/queue", "/amq/queue")
                .setRelayHost("192.168.1.189")
//                .setRelayHost("5673")
                .setClientLogin("mrl")
                .setClientPasscode("shinian")
                .setSystemLogin("mrl")
                .setSystemPasscode("shinian")
                .setSystemHeartbeatSendInterval(5000)
                .setSystemHeartbeatReceiveInterval(4000);
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        //消息过滤器 先不加 报错
        WebSocketHandleInterceptor webSocketHandleInterceptor = new WebSocketHandleInterceptor();
        registration.interceptors(webSocketHandleInterceptor);
    }
}
