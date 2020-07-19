//package com.itcast.erukaservice.config;
//
///**
// * @author: 蔡迪
// * @date: 22:58 2020/7/18
// * @description:
// */
//
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//
///**
//  * @author Herbert
//  * @date 2019/06/24
//  */
//@EnableWebMvc
//public class WebSecurityConfig extends WebMvcConfigurationSupport {
//        @Override
//protected void configure(HttpSecurity http){
//        try{
//        http.csrf().disable()
//        .authorizeRequests()
//        .antMatchers("/actuator/**").permitAll()
//        .anyRequest()
//        .authenticated().and().httpBasic();
//        }catch(Exception e){
//        e.printStackTrace();
//        }
//        }
//        }
