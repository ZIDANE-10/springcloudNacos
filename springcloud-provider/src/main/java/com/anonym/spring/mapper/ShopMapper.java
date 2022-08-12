package com.anonym.spring.mapper;

import com.anonym.spring.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<Shop> selectShop();
}
