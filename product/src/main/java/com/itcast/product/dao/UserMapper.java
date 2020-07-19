package com.itcast.product.dao;

import com.itcast.product.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: 蔡迪
 * @date: 18:44 2020/7/18
 * @description: 用户mapper
 */
//@Repository
public interface UserMapper extends Mapper<User> {

}