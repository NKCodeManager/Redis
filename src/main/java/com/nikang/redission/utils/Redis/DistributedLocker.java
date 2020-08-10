package com.nikang.redission.utils.Redis;/**
 * All rights Reserved, Designed By www.cu-sc.com
 *
 * @Title: DistributedLocker.java
 * @Package com.nikang.redission.utils
 * @Description: TODO
 * @Since: JDK 1.8
 * @Author: nikang
 * @Email: nikang@cu-sc.com
 * @Version: v1.0.0
 * @Date: 2020/8/10 10:56
 * @Copyright: 2020 www.cu-sc.com All rights reserved. <br/>
 * 注意：本内容仅限于联通集团内部传阅，禁止外泄以及用于其他的商业目的<br/>
 */

import com.nikang.redission.exception.UnableToAquireLockException;

/**
 *@ClassName DistributedLocker.java
 *@Description 锁管理类
 *@Author nikang
 *@Date 2020/8/10 10:56
 */
public interface DistributedLocker {

    /**
     * 获取锁
     * @param resourceName  锁的名称
     * @param worker 获取锁后的处理类
     * @param <T>
     * @return 处理完具体的业务逻辑要返回的数据
     * @throws UnableToAquireLockException
     * @throws Exception
     */
    <T> T lock(String resourceName, AquiredLockWorkerBase<T> worker) throws UnableToAquireLockException, Exception;

    <T> T lock(String resourceName, AquiredLockWorkerBase<T> worker, int lockTime) throws UnableToAquireLockException, Exception;

}
