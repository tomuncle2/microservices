package com.itcast.customer.controller.callback;

import com.itcast.customer.controller.feignclient.UserFeign;
import org.springframework.stereotype.Component;

/**
 * @author: 蔡迪
 * @date: 17:39 2020/7/23
 * @description:
 */
@Component
public class UserFeignCallback implements UserFeign {

    /**
     * 熔断回调方法  callback（）和熔断方法返回值 参数列表一致
     * @date 17:41 2020/7/23
     * @param id
     * @return java.lang.Object
     */
    @Override
    public Object getUserById(Integer id) {
        return "服务器繁忙，请稍后再试 " + id;
    }
}