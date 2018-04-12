package com.xin.shiro.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xuexin
 * @date 2018/2/22
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    public Long id;
    public String username;
    public String password;
    public String salt;
    private Boolean locked = Boolean.FALSE;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
