package com.xinyuan.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Created on 2017/12/26.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;
//
//    @Autowired
//    ClientDetailsService clientDetailsService;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore redis = new RedisTokenStore(connectionFactory);
        return redis;
    }

    @Primary
    @Bean
    DefaultTokenServices tokenServices() {
        DefaultTokenServices d = new DefaultTokenServices();
//        d.setClientDetailsService(clientDetailsService);//如果没有设置此项，则client设置的token有效期无效
        d.setTokenStore(tokenStore());
        d.setReuseRefreshToken(true);//是否重复使用refresh_token
        d.setSupportRefreshToken(true);//是否支持refresh_token,为false则refresh_token无法使用
        return d;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")//对于CheckEndpoint控制器[框架自带的校验]的/oauth/token端点允许所有客户端发送器请求而不会被Spring-security拦截
                .checkTokenAccess("isAuthenticated()")//要访问/oauth/check_token必须设置为permitAll(),此接口一般不对外公布，是springoauth2内部使用，因此这里要设为isAuthenticated()
                .allowFormAuthenticationForClients()//允许客户表单认证,不加的话/oauth/token无法访问
                .passwordEncoder(passwordEncoder);//设置oauth_client_details中的密码编码器

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(clientDetailsService);
        clients.inMemory().withClient("xinyuan").scopes("xinyuan1525")
                .authorizedGrantTypes("authorization_code", "refresh_token","password")
                .scopes("all", "read", "write")
                .autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenServices(tokenServices())
                .authenticationManager(authenticationManager);
    }

}
