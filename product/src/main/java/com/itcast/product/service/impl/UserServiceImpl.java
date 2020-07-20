package com.itcast.product.service.impl;

import com.itcast.product.dao.UserMapper;
import com.itcast.product.pojo.User;
import com.itcast.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author: 蔡迪
 * @date: 18:31 2020/7/18
 * @description: 实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id", id);
//        return userMapper.selectOneByExample(example);

        // 写死数据，方便模拟
        User user = null;
        switch (id.intValue()) {
            case 1:user = new User(1,"jack") ;break;
            case 2:user = new User(2,"tom") ;break;
            default:user = new User();
        }
        return user;
    }
}