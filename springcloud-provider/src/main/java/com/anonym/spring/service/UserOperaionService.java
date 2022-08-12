package com.anonym.spring.service;

import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 王培忠
 * @date 2021/02/10
 * @email 805705089@qq.com
 * @Description
 * @Reason ADDREASON
 * @since JDK 1.8
 */
public interface UserOperaionService {


    ResultSet login(User user) throws IOException, ClassNotFoundException;

    ResultSet registered(User user) throws Exception;

    ResultSet verificationEmailOrphone(User user);

    ResultSet selectUserById(Long id) throws Exception;
}
