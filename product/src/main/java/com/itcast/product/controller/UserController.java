package com.itcast.product.controller;

import com.itcast.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 蔡迪
 * @date: 19:08 2020/7/18
 * @description: 用户控制层
 */
@RestController
@RequestMapping("product/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}/getUser")
    public Object getUserById(@PathVariable Integer id){
        System.out.println("");
        return userService.getUserById(id);
    }
}