package com.anonym.spring.pojo;

import com.anonym.spring.model.orderPage.ShopIsExisEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String shopName;
    private String desc;
    private String shopAddr;
    private Double sendPrice;
    private ShopIsExisEnum type;
    private String createTime;
    private String updateTime;
    private String openTime;
    private String closeTime;
    private int orderTotal;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    public Double getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(Double sendPrice) {
        this.sendPrice = sendPrice;
    }

    public ShopIsExisEnum getType() {
        return type;
    }

    public void setType(ShopIsExisEnum type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }
}
