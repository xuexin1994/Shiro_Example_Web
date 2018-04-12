package com.xin.shiro.dao;

import com.xin.shiro.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author xuexin
 * @date 2018/2/23
 */
@Repository
public interface UserDao extends BaseDao<User>{

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
