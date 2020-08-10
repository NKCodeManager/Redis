package com.nikang.redission.utils.Redis;

import com.nikang.redission.config.RedissonConnector;
import com.nikang.redission.exception.UnableToAquireLockException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.cu-sc.com
 *
 * @Title: RedisLocker.java
 * @Package com.nikang.redission.utils.Redis
 * @Description: TODO
 * @Since: JDK 1.8
 * @Author: nikang
 * @Email: nikang@cu-sc.com
 * @Version: v1.0.0
 * @Date: 2020/8/10 11:03
 */

@Component
public class RedisLocker implements DistributedLocker{
    private final static String LOCKER_PREFIX = "lock:";

    @Autowired
    RedissonConnector redissonConnector;

    @Override
    public <T> T lock(String resourceName, AquiredLockWorkerBase<T> worker) throws UnableToAquireLockException, Exception {
        return this.lock(resourceName,worker,100);
    }

    @Override
    public <T> T lock(String resourceName, AquiredLockWorkerBase<T> worker, int lockTime) throws UnableToAquireLockException, Exception {
        RedissonClient redisson= redissonConnector.getClient();
        RLock lock = redisson.getLock(LOCKER_PREFIX + resourceName);
        // Wait for 100 seconds seconds and automatically unlock it after lockTime seconds
        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if (success) {
            try {
                return worker.invokeAfterLockAquire();
            } finally {
                lock.unlock();
            }
        }
        throw new UnableToAquireLockException();
    }
}