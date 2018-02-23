package com.xin.shiro.dao;

import com.xin.shiro.entity.Role;

/**
 * @author xuexin
 * @date 2018/2/23
 */
public interface RoleDao extends BaseDao<Role>{
    void correlationPermissions(Long roleId, Long... permissionIds);

    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
