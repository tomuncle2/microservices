package com.itcast.customer.controller;

import com.itcast.customer.controller.feignclient.UserFeign;
import com.itcast.customer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 蔡迪
 * @date: 11:15 2020/7/23
 * @description: 熔断测试类
 */
@RestController
@RequestMapping("hystrix/")
// 全局降级方法定义  hystrix组件会去寻找getHystrixCircuitBreaker([])的方法
@DefaultProperties(defaultFallback = "getHystrixCircuitBreaker")
public class HystrixController {



    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get")
    // hystrix组件会去寻找getHystrixCircuitBreaker([class java.lang.Integer])的方法
    //@HystrixCommand(fallbackMethod = "getHystrixCircuitBreaker")
    @HystrixCommand
    public String getUserById(Integer id){

        // 加入ribbon负载均衡 提供服务的服务名
        String url = "http://product1";
        User user = restTemplate.getForObject(url + "/product/hystrix/user/v1/"+ id +"/getUser", User.class);
        return null == user ? "" : user.toString();
    }

    /**全居熔断方法
     * Hystrix 熔断/降级方法
     * @date 11:29 2020/7/23
     * @return java.lang.Object
     */
    public String getHystrixCircuitBreaker() {
        return "服务器繁忙，请稍后再试！！";
    }

    /**局部熔断方法
     * Hystrix 熔断/降级方法
     * @date 11:29 2020/7/23
     * @param id
     * @return java.lang.Object
     */
    public String getHystrixCircuitBreaker(Integer id) {
        return "服务器繁忙，请稍后再试！！" + id;
    }


}