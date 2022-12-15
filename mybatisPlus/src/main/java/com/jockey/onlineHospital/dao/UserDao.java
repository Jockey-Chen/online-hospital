package com.jockey.onlineHospital.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jockey.onlineHospital.beans.User;
import org.springframework.stereotype.Repository;

//BaseMapper<T>接口为mybatisPlus接口，封装了常用的增删改查方法
@org.apache.ibatis.annotations.Mapper
public interface UserDao extends BaseMapper<User> {
}
