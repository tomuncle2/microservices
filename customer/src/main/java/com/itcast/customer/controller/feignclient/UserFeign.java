package com.itcast.customer.controller.feignclient;

import com.itcast.customer.controller.callback.UserFeignCallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: 蔡迪
 * @date: 17:34 2020/7/23
 * @description: 消费者用户信息feign fallbackFactory:用可以获得回退触发的原因
 */
@FeignClient(value = "PRODUCT1", fallback = UserFeignCallback.class)
public interface UserFeign {

    /**
     * 请求生产者用户信息
     * @date 17:41 2020/7/23
     * @param id
     * @return java.lang.Object
     */
    // 模拟请求controller 默认集成ribbon和hystrix
    @GetMapping("/product/hystrix/user/v1/{id}/getUserById")
    Object getUserById(@PathVariable Integer id);
}