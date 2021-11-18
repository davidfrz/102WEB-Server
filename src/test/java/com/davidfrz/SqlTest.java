package com.davidfrz;

import com.atguigu.mvc.dao.MqttDao;
import com.atguigu.mvc.dao.impl.MqttDaoImpl;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SqlTest {

    @Test
    public void test(){
        MqttDao mqttDao = new MqttDaoImpl();
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ti = "1636368743";
        String time = SimpleDateFormat.format(
                new Date(Long.valueOf(ti+"000")
                ));
        mqttDao.saveSamp("123","12","32",time);
    }

    @Test
    public void test2() throws ParseException {
        MqttDao mqttDao = new MqttDaoImpl();
        List<Map<String, Object>> gpsByTimeAndImei = mqttDao.getGpsByTimeAndImei("1254", "2021-11-08","2021-11-09");
        System.out.println(gpsByTimeAndImei);
    }

    @Test
    public void test3() throws ParseException {
        String a ="2021-11-08 23:59:00";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nextDay = df.parse(a);



    }
}
