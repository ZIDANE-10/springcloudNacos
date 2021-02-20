package com.anonym.springcloudcustomer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestVueController {

    @RequestMapping("/testVue")
    public String testVue(@RequestParam(value = "firstName",required = true) String firstName, HttpServletResponse response){
        return firstName;
    }
}
