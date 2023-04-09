package com.juguopeng.springboot;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {
    @Resource
    UserService userService;
    @Autowired
    UserMapper userMapper;
    //对service进行操作
    @Test
    public void selectByAccountAndPwd() {
        System.out.println(userService.selectById(2));
    }

    @Test
    public void testList() {
        List<User> userList = userMapper.list();
        System.out.println("User List:");
        for (User user : userList) {
            System.out.println(user);
        }
    }

//    @Test
//    public void testSave(){
//        User user=new User("666","whbadj","12431");
//        userMapper.saveUser(user);
//
//    }



}
