package com.nikang.redission.exception;

/**
 * All rights Reserved, Designed By www.cu-sc.com
 *
 * @Title: UnableToAquireLockException.java
 * @Package com.nikang.redission.exception
 * @Description: TODO
 * @Since: JDK 1.8
 * @Author: nikang
 * @Email: nikang@cu-sc.com
 * @Version: v1.0.0
 * @Date: 2020/8/10 10:57
 * @Copyright: 2020 www.cu-sc.com All rights reserved. <br/>
 * 注意：本内容仅限于联通集团内部传阅，禁止外泄以及用于其他的商业目的<br/>
 */

public class UnableToAquireLockException extends RuntimeException{

    public UnableToAquireLockException() {
    }
    public UnableToAquireLockException(String message) {
        super(message);
    }
    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}