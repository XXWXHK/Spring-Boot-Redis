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

}
