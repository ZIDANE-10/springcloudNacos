package com.anonym.spring.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.spring.service.UserOperaionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("provider")
public class UserOperationController {

    @Resource
    private UserOperaionService userOperaionService;

    @RequestMapping("login")
    public ResultSet login(User user){
        ResultSet resultSet = new ResultSet();
        return resultSet;
    }
}
