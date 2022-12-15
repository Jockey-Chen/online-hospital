package com.jockey.onlineHospital.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jockey.onlineHospital.beans.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void testQuery(){
        System.out.println(userDao.selectById(7));
    }

    @Test
    public void testAdd(){
        User user=new User(null,"Jerry","123",20,"male","Tom@qq.com");
        userDao.insert(user);
    }

    @Test
    public void testUpdate(){
        User user=new User(20,"Tom","123",20,"male","Tom@qq.com");
        userDao.updateById(user);
    }

    @Test
    public void testOptimisticLocker(){
        User user=userDao.selectById(20);
        user.setEmail("niubilty1@qq.com");
        userDao.updateById(user);
    }

    @Test
    public void testSelectByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","Tom");
        map.put("sex","male");
        System.out.println(userDao.selectByMap(map));
    }

    @Test
    public void testPage(){
        Page<User> page=userDao.selectPage(new Page<>(1,5),null);
        System.out.println("总页数："+page.getPages()+
                "\n当前页码:"+page.getCurrent()+
                "\n总记录条数:"+page.getTotal()+
                "\n当前页内容:"+page.getRecords());
    }

    @Test
    public void testWrapper(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.ge("age",25);   //great or equal
        List<User> list=userDao.selectList(wrapper);
        System.out.println(list);
    }
}