package cn.com.xuxiaowei.springbootredis;

import cn.com.xuxiaowei.springbootredis.entity.User;
import cn.com.xuxiaowei.springbootredis.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    /**
     * 这里直接注入即可
     */
    @Autowired
    private IUserService userService;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试 插入一条记录（选择字段，策略插入，Redis）
     */
    @Test
    public void saveCachePut() {

        User user = new User().setNickname("测试昵称" + LocalTime.now());

        userService.saveCachePut(user);

        System.err.println(user);
    }

    /**
     * 测试 TableId 注解存在更新记录，否插入一条记录，Redis
     */
    @Test
    public void saveOrUpdateCachePut() {

        User user = new User().setNickname("测试昵称" + LocalTime.now());

        // 存在主键，修改数据，
        // 不存在主键，保存数据
        user.setId(30);

        userService.saveOrUpdateCachePut(user);

        System.err.println(user);
    }

    /**
     * 测试 根据 ID 删除，Redis
     */
    @Test
    public void removeByIdCacheEvict() {

        boolean removeByIdCacheEvict = userService.removeByIdCacheEvict(26);

        System.err.println(removeByIdCacheEvict);
    }


}
