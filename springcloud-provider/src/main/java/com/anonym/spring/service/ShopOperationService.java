package com.anonym.spring.service;

import com.anonym.spring.model.ResultSet;

public interface ShopOperationService {
    ResultSet selectShop(String type,Long userId);
}
