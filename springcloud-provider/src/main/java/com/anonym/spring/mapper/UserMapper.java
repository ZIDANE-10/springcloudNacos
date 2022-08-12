package com.anonym.spring.mapper;


import com.anonym.spring.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User verificationLongin(User user);

    int registered(User user);

    User isExistsUser(User user);

    User verificationPhoneOrEmail(User user);

    User selectUserById(Long id);
}
