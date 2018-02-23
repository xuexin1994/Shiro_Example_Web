package com.xin.shiro.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @author xuexin
 * @date 2018/2/22
 */
@Data
@RequiredArgsConstructor
public class RolePermssion implements Serializable {
    private Long roleId;
    private Long permissionId;
}
