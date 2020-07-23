package com.itcast.customer;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CustomerApplication.class)
@RunWith(SpringRunner.class)
public class CustomerApplicationTests {

    @Autowired
    private RibbonLoadBalancerClient ribbonLoadBalancerClient;

    // 模拟多个请求 默认轮训算法
    @Test
    public void contextLoads() {
        for (int i =0;i<50;i++) {
            ServiceInstance serviceInstance = ribbonLoadBalancerClient.choose("product1");
            System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
        }
    }

}
