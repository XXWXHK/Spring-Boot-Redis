package cn.com.xuxiaowei.springbootredis.service;

import cn.com.xuxiaowei.springbootredis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表（测试） 服务类
 * </p>
 *
 * @author 徐晓伟
 * @since 2019-05-18
 */
public interface IUserService extends IService<User> {

    /**
     * 插入一条记录（选择字段，策略插入，Redis）
     * <p>
     * 无论如何都插入到数据并保存到Redis
     * <p>
     *
     * @param entity 要插入的实体对象
     * @return 实体对象（插入结果返回了实体类主键）
     */
    User saveCachePut(User entity);

    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录，Redis
     * </p>
     * 无论如何都 插入/更新 到数据并保存到Redis
     * <p>
     *
     * @param entity 实体对象
     * @return 返回 插入/更新 到数据库/Redis的实体类对象（含主键）
     */
    User saveOrUpdateCachePut(User entity);

    /**
     * 根据 ID 删除，Redis
     * <p>
     * 移除缓存对应的 Key 的值
     * <p>
     * value 放入Redis中的值
     * key 实体类的主键（需要有唯一性）
     *
     * @param id 主键 ID，与实体类的主键类型相同
     * @return 返回 删除状态
     */
    boolean removeByIdCacheEvict(Integer id);

    /**
     * 根据 ID 查询，Redis
     * <p>
     * 进入方法前，Spring 会先去缓存服务器中查找对应 Key 的缓存值，
     * 如果找到缓存值，那么 Spring 将不会再调用方法，而是将缓存值缓存值读出，返回给调用者（没有执行SQL）；
     * 如果没有找到缓存值，那么 Spring 就会执行你的方法，将最后的结果通过 Key 保存到缓存服务器中（执行了SQL）
     *
     * @param id 主键ID，与实体类的主键类型相同
     * @return 返回 查询结果（实体类对象）
     */
    User getByIdCacheable(Integer id);

}
