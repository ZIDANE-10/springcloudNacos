package com.anonym.spring.model.orderPage;

import java.util.HashMap;
import java.util.Map;

public enum UserTypeEnum {

    OrdinaryUser("OrdinaryUser", "普通用户"), business("business", "商家");


    private final String value;

    private final String description;

    public String toString(){
        return description;
    }

    UserTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<String, UserTypeEnum> map = new HashMap<>();

    static {
        UserTypeEnum[] array = UserTypeEnum.values();
        for (UserTypeEnum e : array) {
            map.put(e.getValue(), e);
        }
    }

    public static UserTypeEnum forValue(String s) {
        return map.get(s);
    }

    public static String getDes(String value){
        return map.get(value).getDescription();
    }
}
