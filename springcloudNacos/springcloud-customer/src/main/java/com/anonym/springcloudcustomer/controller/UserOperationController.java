package com.anonym.springcloudcustomer.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.springcloudcustomer.service.UserOperationFeignClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserOperationController {

    @Resource
    private UserOperationFeignClient userOperationFeignClient;


    @RequestMapping("/login")
    public ResultSet login(User user){
        ResultSet resultSet = new ResultSet();
        try {
            if(StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())){
                resultSet.setRetCode("0");
                resultSet.setRetVal("必传参数为空");
                return resultSet;
            }
            resultSet = userOperationFeignClient.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
