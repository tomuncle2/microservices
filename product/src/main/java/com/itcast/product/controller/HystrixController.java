package com.itcast.product.controller;

import com.itcast.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author: 蔡迪
 * @date: 16:31 2020/7/23
 * @description: 熔断controller
 */
@RestController
@RequestMapping("product/hystrix/user/v1")
public class HystrixController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}/getUser")
    public Object getUser(@PathVariable Integer id){
        // 模拟请求超时
        try {
            TimeUnit.SECONDS.sleep(13);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/getUserById")
    public Object getUserById(@PathVariable Integer id){

        return userService.getUserById(id);
    }
}