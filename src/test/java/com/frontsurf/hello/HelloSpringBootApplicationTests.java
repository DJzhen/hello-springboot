package com.frontsurf.hello;

import com.frontsurf.hello.commons.mapper.UserMapper;
import com.frontsurf.hello.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class HelloSpringBootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println("hello");
    }

    @Test
    public void  testSelectAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("wangsf");
        user.setAge(0);
        userMapper.insert(user);

    }

    @Test
    public void testUpdate() {
        User user = userMapper.selectByPrimaryKey(1);
        user.setAge(100);
        userMapper.updateByPrimaryKey(user);
    }

    @Test
    public void testDelete() {
        userMapper.deleteByPrimaryKey(1);
    }

    @Test
    public void testpage() {
        PageHelper.startPage(0, 2);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectAll());
        System.out.println(pageInfo);
    }

}
