package com.nikang.redission.utils.Redis;/**
 * All rights Reserved, Designed By www.cu-sc.com
 *
 * @Title: AquiredLockWorkerBase.java
 * @Package com.nikang.redission.utils
 * @Description: TODO
 * @Since: JDK 1.8
 * @Author: nikang
 * @Email: nikang@cu-sc.com
 * @Version: v1.0.0
 * @Date: 2020/8/10 10:54
 * @Copyright: 2020 www.cu-sc.com All rights reserved. <br/>
 * 注意：本内容仅限于联通集团内部传阅，禁止外泄以及用于其他的商业目的<br/>
 */

/**
 *@ClassName AquiredLockWorkerBase.java
 *@Description TODO
 *@Author nikang
 *@Date 2020/8/10 10:54
 */
public interface AquiredLockWorkerBase<T> {
    T invokeAfterLockAquire() throws Exception;
}
