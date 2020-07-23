package com.itcast.customer.controller;

import com.itcast.customer.controller.feignclient.UserFeign;
import com.itcast.customer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 蔡迪
 * @date: 17:47 2020/7/23
 * @description:
 */
@RestController
@RequestMapping("feign/")
public class UserFeginController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("get")
    public String getUserById(Integer id){

        //
        Object user = userFeign.getUserById(id);
        return null == user ? "" : user.toString();
    }
}