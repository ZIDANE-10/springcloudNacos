package com.anonym.springcloudcustomer.service;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("springcloud-provider")
public interface UserOperationFeignClient {

    @RequestMapping("/provider/login")
    ResultSet login(@RequestBody User user);

}
