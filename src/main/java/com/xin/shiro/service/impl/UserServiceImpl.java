package com.xin.shiro.service.impl;

import com.xin.shiro.entity.User;
import com.xin.shiro.service.UserService;

import java.util.Set;

/**
 * @author xuexin
 * @date 2018/2/22
 */
public class UserServiceImpl implements UserService {
    public User createUser(User user) {
        return null;
    }

    public void changePassword(Long userId, String newPassword) {

    }

    public void correlationRoles(Long userId, Long... roleIds) {

    }

    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    public User findByUsername(String username) {
        return null;
    }

    public Set<String> findRoles(String username) {
        return null;
    }

    public Set<String> findPermissions(String username) {
        return null;
    }
}
