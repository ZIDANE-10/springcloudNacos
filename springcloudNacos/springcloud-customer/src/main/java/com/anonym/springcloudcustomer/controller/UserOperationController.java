package com.anonym.springcloudcustomer.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.springcloudcustomer.service.UserOperationFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserOperationController {

    @Resource
    private UserOperationFeignClient userOperationFeignClient;


    @RequestMapping("/login")
    public ResultSet login(){
        ResultSet resultSet = new ResultSet();
        try {
            resultSet = userOperationFeignClient.login();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
