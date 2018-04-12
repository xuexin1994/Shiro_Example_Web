package com.xin.shiro.dao;

/**
 * @author xuexin
 * @date 2018/2/23
 */
public interface BaseDao<T> {
    /**
     * 根据ID查询实体
     * @param id 主键
     * @return 实体信息
     */
    T get(Integer id);
    /**
     * 新增实体
     * @param t 实体信息
     * @return 新增结果（true/false）
     */
    boolean insert(T t);
    /**
     * 更新实体
     * @param t 实体信息
     * @return 更新结果（true/false）
     */
    boolean update(T t);
    /**
     * 物理删除
     * @param id 实体主键
     * @return 删除结果（true/false）
     */
    boolean delete(Integer id);
}
