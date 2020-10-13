package com.cy.web;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cy.web.entity.User;
import com.cy.web.mapper.UserMapper;
import com.cy.web.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
class WebApplicationTests {
    
    private final UserMapper userMapper;
    private final IUserService userService;
     private final RedisTemplate redisTemplate;
    //private final StringRedisTemplate redisTemplate;
    @Resource
    private final ApplicationContext applicationContext;
    private QueryWrapper<User> queryWrapper = new QueryWrapper<>();

    @Test
    public void test_1() {

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);

    }

    @Test
    public void test_2() {

        User user = new User();
        user.setAccount("2858749506").setHeadImg("").setLevel("192").setNickname("cy").setPassword("980529");
        userMapper.insert(user);
        System.out.println("user = " + user.getId());
        System.out.println(user);

    }
    @Test
    public void test_3() {

        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);

    }
    @Test
    public void test_4() {

        List<User> list = userService.list();
        System.out.println(list);

    }
    @Test
    public void test_5() {

        DataSource dataSource = applicationContext.getBean(DataSource.class);

        System.out.println("dataSource = " + dataSource);
        System.out.println("dataSourceName = " + dataSource.getClass().getName());

    }

    @Test
    public void test_6() {

        Object demo = redisTemplate.opsForValue().get("demo");
        System.out.println("demo = " + demo);

    }

    @Test
    public void test_7() {

        User user = new User();
        user.setNickname("Cy");

        redisTemplate.opsForHash().put("123","123",user);

    }
    @Test
    public void test_8() {

        try {
            //获得的是LinkedMap对象
            Map o = (Map) redisTemplate.opsForHash().get("123", "123");
            System.out.println("o = " + o.getClass());
            System.out.println("o = " + o);
            String json  = new JSONObject(o).toJSONString();
            System.out.println("json = " + json);
            User user = JSONObject.parseObject(json, User.class);
            System.out.println("user = " + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }



}
