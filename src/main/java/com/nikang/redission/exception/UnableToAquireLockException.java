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