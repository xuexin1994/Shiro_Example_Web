package com.xin.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuexin
 * @date 2018/2/22
 */
@Data
public class UserRole implements Serializable {
    private Long userId;
    private Long roleId;
}
