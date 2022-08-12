package com.anonym.spring.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.service.ShopOperationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/provider")
@RestController
public class ShopProviderOperationController {

    @Resource
    private ShopOperationService shopOperationService;

    @RequestMapping("/selectShop")
    public ResultSet selectShop(String type,Long userId){
        ResultSet resultSet = new ResultSet();
        try {
            resultSet = shopOperationService.selectShop(type,userId);
        } catch (Exception e) {
            e.printStackTrace();
            resultSet.setRetCode("0");
            resultSet.setRetVal("网络繁忙,请稍后再试");
            return resultSet;
        }
        return resultSet;
    }

}
