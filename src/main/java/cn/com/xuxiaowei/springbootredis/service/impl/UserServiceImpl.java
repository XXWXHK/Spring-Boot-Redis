package cn.com.xuxiaowei.springbootredis.service.impl;

import cn.com.xuxiaowei.springbootredis.entity.User;
import cn.com.xuxiaowei.springbootredis.framework.tool.SuperSqlHelper;
import cn.com.xuxiaowei.springbootredis.mapper.UserMapper;
import cn.com.xuxiaowei.springbootredis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表（测试） 服务实现类
 * </p>
 *
 * @author 徐晓伟
 * @since 2019-05-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 用于统一Redis中的value值
     * <p>
     * 必须为常量
     */
    private final String USER = "User";

    /**
     * 插入一条记录（选择字段，策略插入，Redis）
     * <p>
     * 无论如何都插入到数据并保存到Redis
     * <p>
     * value 放入Redis中的值
     * key 实体类的主键（需要有唯一性）
     *
     * @param entity 要插入的实体对象
     * @return 实体对象（插入结果返回了实体类主键）
     */
    @Override
    @CachePut(value = USER, key = "#entity.id")
    public User saveCachePut(User entity) {
        int insert = super.baseMapper.insert(entity);
        return SuperSqlHelper.retBool(insert, entity);
    }

    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录，Redis
     * </p>
     * 无论如何都 插入/更新 到数据并保存到Redis
     * <p>
     * value 放入Redis中的值
     * key 实体类的主键（需要有唯一性）
     *
     * @param entity 实体对象
     * @return 返回 插入/更新 到数据库/Redis的实体类对象（含主键）
     */
    @Override
    @CachePut(value = USER, key = "#entity.id")
    public User saveOrUpdateCachePut(User entity) {
        boolean update = super.saveOrUpdate(entity);
        return SuperSqlHelper.retBool(update, entity);
    }

}
