package com.itcast.customer.pojo;

/**
 * @author: 蔡迪
 * @date: 18:42 2020/7/18
 * @description: 用户类
 */

public class User {

    private Integer id;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}