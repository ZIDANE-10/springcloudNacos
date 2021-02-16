package com.anonym.spring.service;

import com.anonym.spring.mapper.MenuMapper;
import com.anonym.spring.mapper.ShopMapper;
import com.anonym.spring.mapper.UserShopToMenu;
import com.anonym.spring.mapper.UserShopToShopMapper;
import com.anonym.spring.model.ResultSet;
import com.anonym.spring.pojo.Menu;
import com.anonym.spring.pojo.Shop;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopOperationServiceImpl implements ShopOperationService{

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private UserShopToShopMapper userShopToShopMapper;

    @Resource
    private UserShopToMenu userShopToMenu;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public ResultSet selectShop(String type,Long userId) {
        ResultSet resultSet = new ResultSet();
        /*必须是普通用户才能查询此接口*/
        if(type.equals("OrdinaryUser")){
            /*查询店铺信息*/
            List<Shop> shopList = shopMapper.selectShop();
            if(shopList.isEmpty()){
                /*为空*/
                resultSet.setRetCode("1");
                resultSet.setRetVal("");
                resultSet.setDataRows(null);
                return resultSet;
            }
            resultSet.setRetCode("1");
            resultSet.setRetVal("");
            resultSet.setDataRows(shopList);
        }else if(type.equals("business")){
            /*如果是商家查询此接口，则显示商家的菜品*/
            /*先查关联表如果没有数据直接返回*/
            String shopId = userShopToShopMapper.selectIsExtis(userId);
            if(StringUtils.isEmpty(shopId)){
                /*证明没有店铺*/
                resultSet.setRetCode("0");
                resultSet.setRetVal("您还没有店铺哦！快去创建一个吧");
                return resultSet;
            }else{
                /*证明有值,查询菜品*/
                /*定义商品list*/
                List<Menu> menuList = new ArrayList<>();
                /*定义商品id的list*/
                List<String> menuIds = new ArrayList<>();
                menuIds = userShopToMenu.selectMenuIds(shopId);
                if(!menuIds.isEmpty()){
                    /*循环每个menuId,拿出菜品，使用索引查询*/
                    Menu menu = new Menu(); // 创建菜品对象
                    for (String menuId : menuIds) {
                        menu = menuMapper.selectMenuById(menuId);
                        menuList.add(menu);
                    }
                }
                resultSet.setRetCode("1");
                resultSet.setRetVal("");
                resultSet.setDataRows(menuList);
                return resultSet;
            }
        }else{
            resultSet.setRetCode("0");
            resultSet.setRetVal("非法访问");
            return resultSet;
        }
        return resultSet;
    }
}
