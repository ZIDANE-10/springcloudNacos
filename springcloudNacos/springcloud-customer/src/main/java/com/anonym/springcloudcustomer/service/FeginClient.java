package com.anonym.springcloudcustomer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("springcloud-provider")
public interface FeginClient {

    @RequestMapping("/hello")
    String helloword();

}
