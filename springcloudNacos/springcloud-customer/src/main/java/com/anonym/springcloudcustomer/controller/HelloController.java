package com.anonym.springcloudcustomer.controller;

import com.anonym.springcloudcustomer.service.FeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private FeginClient feginClient;

    @RequestMapping("/hello-customer")
    public String hello(){
        String result = feginClient.helloword();
        return "this is"+result;
    }

}
