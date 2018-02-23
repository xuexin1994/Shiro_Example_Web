package com.xin.shiro.exception;

/**
 * @author xuexin
 * @date 2018/2/23
 */
public class CustomerException extends Exception{
    private static final long serialVersionUID = 1L;
    public CustomerException() {
        super();
    }
    private String message;

    public CustomerException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
