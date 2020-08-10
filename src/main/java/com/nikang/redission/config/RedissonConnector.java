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
 * @Copyright: 2020 www.cu-sc.com All rights reserved. <br/>
 * 注意：本内容仅限于联通集团内部传阅，禁止外泄以及用于其他的商业目的<br/>
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