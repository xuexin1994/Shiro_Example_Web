package com.xin.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuexin
 * @date 2018/2/22
 */
@Data
public class User implements Serializable {
    public Long id;
    public String username;
    public String password;
    public String salt;
    private Boolean locked = Boolean.FALSE;
}
