package com.itcast.customer.controller;

import com.itcast.customer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 蔡迪
 * @date: 19:15 2020/7/18
 * @description:
 */
@RestController
@RequestMapping("customer/v1")
public class UserinfoController {

    @Autowired
    private RestTemplate restTemplate;

    // cloud-client端自带
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("get")
    public Object getUserById(Integer id){

// 1.
//        User user = restTemplate.getForObject("http://localhost:7845/product/user/v1/"+ id +"/getUser", User.class);

        // 2.解决地址硬编码问题
//        List<ServiceInstance>  list = discoveryClient.getInstances("product1");
//        ServiceInstance serviceInstance = list.get(0);
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
//         User user = restTemplate.getForObject(url + "/product/user/v1/"+ id +"/getUser", User.class);


         // 加入负载均衡 提供服务的服务名
        String url = "http://product1";
        User user = restTemplate.getForObject(url + "/product/user/v1/"+ id +"/getUser", User.class);
         return user;
    }
}