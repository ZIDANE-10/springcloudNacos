package com.anonym.springcloudcustomer.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.springcloudcustomer.conf.ReflexMultiValueMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/shop")
@RestController
public class ShopCustomerOperationController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ReflexMultiValueMap reflexMultiValueMap;

    @RequestMapping("/selectShop")
    public ResultSet selectShop(String type, HttpServletResponse response,Long userId){
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResultSet resultSet = new ResultSet();
        try {
            if(StringUtils.isEmpty(type)){
                resultSet.setRetCode("0");
                resultSet.setRetVal("必传参数为空");
                return resultSet;
            }
            //resultSet = userOperationFeignClient.login(user);
            MultiValueMap<Object,Object> map = new LinkedMultiValueMap<>();
            map.add("type",type);
            map.add("userId",userId);
            return restTemplate.postForEntity("http://springcloud-provider/provider/selectShop",map,ResultSet.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            resultSet.setRetCode("0");
            resultSet.setRetVal("网络繁忙,请稍后再试");
            return resultSet;
        }
    }
}
