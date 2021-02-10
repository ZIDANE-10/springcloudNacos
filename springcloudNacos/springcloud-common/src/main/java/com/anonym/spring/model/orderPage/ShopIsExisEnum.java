package com.anonym.spring.model.orderPage;

import java.util.HashMap;
import java.util.Map;

public enum ShopIsExisEnum {

    open("open", "开启"), close("close", "关闭");


    private final String value;

    private final String description;

    public String toString(){
        return description;
    }

    ShopIsExisEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<String, ShopIsExisEnum> map = new HashMap<>();

    static {
        ShopIsExisEnum[] array = ShopIsExisEnum.values();
        for (ShopIsExisEnum e : array) {
            map.put(e.getValue(), e);
        }
    }

    public static ShopIsExisEnum forValue(String s) {
        return map.get(s);
    }

    public static String getDes(String value){
        return map.get(value).getDescription();
    }
}
