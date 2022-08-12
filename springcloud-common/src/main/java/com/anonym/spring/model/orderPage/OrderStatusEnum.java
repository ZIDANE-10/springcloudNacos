package com.anonym.spring.model.orderPage;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatusEnum {

    open("open", "开启"), close("close", "关闭"),

    refundIng("refundIng", "退款中") , refundOk("refundOk","退款成功"),
    orderSuccess("orderSuccess","订单成功完成");


    private final String value;

    private final String description;

    public String toString(){
        return description;
    }

    OrderStatusEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<String, OrderStatusEnum> map = new HashMap<>();

    static {
        OrderStatusEnum[] array = OrderStatusEnum.values();
        for (OrderStatusEnum e : array) {
            map.put(e.getValue(), e);
        }
    }

    public static OrderStatusEnum forValue(String s) {
        return map.get(s);
    }

    public static String getDes(String value){
        return map.get(value).getDescription();
    }
}
