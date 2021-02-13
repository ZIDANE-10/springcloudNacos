package com.anonym.spring.controller;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import com.anonym.spring.service.UserOperaionService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author 王培忠
 * @date 2021/02/10
 * @email 805705089@qq.com
 * @Description
 * @Reason ADDREASON
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/provider")
public class UserProviderOperationController {

    private static Logger logger = LoggerFactory.getLogger(UserProviderOperationController.class);

    @Resource
    private UserOperaionService userOperaionService;

    /*登陆*/
    @RequestMapping("/login")
    public ResultSet login(User user){

        ResultSet resultSet = new ResultSet();
        try {
            resultSet = userOperaionService.login(user);
        } catch (Exception e) {
            resultSet.setRetCode("0");
            resultSet.setRetVal("网络繁忙，请稍后再试");
            logger.error("****",e);
            return resultSet;
        }
        return resultSet;
    }

    /*注册*/
    @RequestMapping("/registered")
    public ResultSet registered (User user){
        ResultSet resultSet = new ResultSet();
        try {
            resultSet = userOperaionService.registered(user);

        } catch (Exception e) {
            e.printStackTrace();
            resultSet.setRetCode("0");
            resultSet.setRetVal("网络繁忙，请稍后再试");
            e.printStackTrace();
            return resultSet;
        }
        return resultSet ;
    }

    @RequestMapping("/verificationEmailOrphone")
    public ResultSet verificationEmailOrphone(User user){

        ResultSet resultSet = new ResultSet();
        try {
            resultSet = userOperaionService.verificationEmailOrphone(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
