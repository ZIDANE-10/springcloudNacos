package com.anonym.springcloudcustomer.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.model.orderPage.UserTypeEnum;
import com.anonym.spring.pojo.User;
import com.anonym.springcloudcustomer.conf.ReflexMultiValueMap;
import com.anonym.springcloudcustomer.service.UserOperationFeignClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserCustomerOperationController {

    @Resource
    private UserOperationFeignClient userOperationFeignClient;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ReflexMultiValueMap reflexMultiValueMap;
    /*登陆*/
    @RequestMapping("/login")
    public ResultSet login(User user,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResultSet resultSet = new ResultSet();

        try {
            if(StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())){
                resultSet.setRetCode("0");
                resultSet.setRetVal("必传参数为空");
                return resultSet;
            }
            //resultSet = userOperationFeignClient.login(user);
            MultiValueMap<Object,Object> map = new LinkedMultiValueMap<>();
            MultiValueMap<Object, Object> objectObjectMultiValueMap = reflexMultiValueMap.setObjToMap(map, user);
            return restTemplate.postForEntity("http://springcloud-provider/provider/login",objectObjectMultiValueMap,ResultSet.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    /*注册*/
    @RequestMapping(value = "/registered",method = RequestMethod.POST)
    public ResultSet registered(User user ,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResultSet resultSet = new ResultSet();

        try {
            if (StringUtils.isEmpty(user.getPhone()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getEmail())){
                resultSet.setRetCode("0");
                resultSet.setRetVal("必传参数为空");
                return resultSet;
            }
            MultiValueMap<Object,Object> map = new LinkedMultiValueMap<>();
            MultiValueMap<Object, Object> objectObjectMultiValueMap = reflexMultiValueMap.setObjToMap(map, user);
            return restTemplate.postForEntity("http://springcloud-provider/provider/registered",objectObjectMultiValueMap,ResultSet.class).getBody() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @RequestMapping("/verificationEmailOrphone")
    public ResultSet verificationEmailOrphone(User user,HttpServletResponse response){
        ResultSet resultSet = new ResultSet();
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            if(StringUtils.isEmpty(user.getPhone()) & StringUtils.isEmpty(user.getEmail())){
                /*两者都为空证明前端有问题*/
                resultSet.setRetCode("0");
                resultSet.setRetVal("必传参数为空");
                return resultSet;
            }
            MultiValueMap<Object,Object> map = new LinkedMultiValueMap<>();
            MultiValueMap<Object, Object> objectObjectMultiValueMap = reflexMultiValueMap.setObjToMap(map, user);
            return restTemplate.postForEntity("http://springcloud-provider/provider/verificationEmailOrphone",objectObjectMultiValueMap,ResultSet.class).getBody() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
