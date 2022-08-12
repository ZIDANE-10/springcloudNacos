package com.anonym.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserShopToMenu {


    List<String> selectMenuIds(String shopId);
}
