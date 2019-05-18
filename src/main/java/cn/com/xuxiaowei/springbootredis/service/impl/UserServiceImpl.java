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
    @CachePut(value = "User", key = "#entity.id")
    public User saveCachePut(User entity) {
        int insert = super.baseMapper.insert(entity);
        return SuperSqlHelper.retBool(insert, entity);
    }

}
