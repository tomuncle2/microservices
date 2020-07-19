package com.itcast.product.service;

import com.itcast.product.pojo.User;

/**
 * @author: 蔡迪
 * @date: 18:30 2020/7/18
 * @description: 用户服务接口
 */
public interface UserService {

    User getUserById(Integer id);
}