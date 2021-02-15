package com.anonym.spring.mapper;

import com.anonym.spring.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    Menu selectMenuById(String menuId);
}
