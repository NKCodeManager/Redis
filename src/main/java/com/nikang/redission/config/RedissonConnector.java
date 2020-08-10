package com.nikang.redission.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * All rights Reserved, Designed By www.cu-sc.com
 *
 * @Title: RedissonConnector.java
 * @Package com.nikang.redission.config
 * @Description: TODO
 * @Since: JDK 1.8
 * @Author: nikang
 * @Email: nikang@cu-sc.com
 * @Version: v1.0.0
 * @Date: 2020/8/10 10:59
 */
@Component
public class RedissonConnector {
    RedissonClient redisson;
    @PostConstruct
    public void init(){
        redisson = Redisson.create();
    }

    public RedissonClient getClient(){
        return redisson;
    }
}