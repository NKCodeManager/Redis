package com.nikang.redission.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.TransportMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * All rights Reserved, Designed By www.cu-sc.com
 *
 * @Title: RedissionClientConfig.java
 * @Package com.nikang.redission.config
 * @Description: TODO
 * @Since: JDK 1.8
 * @Author: nikang
 * @Email: nikang@cu-sc.com
 * @Version: v1.0.0
 * @Date: 2020/8/10 11:00
 * @Copyright: 2020 www.cu-sc.com All rights reserved. <br/>
 * 注意：本内容仅限于联通集团内部传阅，禁止外泄以及用于其他的商业目的<br/>
 */
@Configuration
public class RedissionClientConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer().setAddress("redis://" + host + ":" + port);
        if(!StringUtils.isEmpty(password)){
            singleServerConfig.setPassword(password);
        }
        System.out.println("------------- redisson -----------------------");
        System.out.println(config.getTransportMode());
//        config.setTransportMode(TransportMode.EPOLL);
//        TransportMode.EPOLL 只能在linux下使用,原则上应该比默认的nio快
        return Redisson.create(config);

    }
}