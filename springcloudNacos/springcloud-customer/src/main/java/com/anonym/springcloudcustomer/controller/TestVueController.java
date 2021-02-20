package com.anonym.springcloudcustomer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestVueController {

    @RequestMapping("/testVue")
    public String testVue(String firstName, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return firstName;
    }
}
