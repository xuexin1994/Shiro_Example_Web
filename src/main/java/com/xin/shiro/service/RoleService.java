package com.xin.shiro.service;

import com.xin.shiro.entity.Role;

/**
 * @author xuexin
 * @date 2018/2/22
 */
public interface RoleService {
    Role createRole(Role role);
    void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
