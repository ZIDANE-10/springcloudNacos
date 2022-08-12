package com.anonym.spring.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${付鸿儒} on 2021/2/11 17:04
 */
public class DateUtils {

    public static String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }
}
