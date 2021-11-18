package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.BrightMan;
import com.atguigu.mvc.bean.User;
import com.atguigu.mvc.dao.MqttDao;
import com.atguigu.mvc.dao.impl.MqttDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Date:2021/7/6
 * Author:ybc
 * Description:
 */
@Controller
public class ParamController {

    SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/testBean")
    @ResponseBody
    public User testBean(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping("/testMqtt")
    @ResponseBody
    public void testBean(@RequestBody BrightMan samp){
//        System.out.println(samp);
//        System.out.println(SimpleDateFormat.format(new Date(Long.valueOf(samp.getTim()+"000"))));
//        System.out.println("**********");
        String ti = (String) samp.getTim();
        System.out.println(ti);
//        String time = SimpleDateFormat.format(
//                new Date(Long.valueOf(ti+"000")
//                ));
        MqttDao mqttDao = new MqttDaoImpl();
        Integer rows = mqttDao.saveSamp(
                samp.getImei(),
                samp.getLng(),
                samp.getLat(),
                ti
        );
        System.out.println("添加成功？"+rows);
    }

    @RequestMapping("/getSinGps")
    @ResponseBody
    public List<Map<String, Object>> getSinGps(HttpServletRequest req) throws ParseException {
        MqttDao mqttDao = new MqttDaoImpl();
        String imei = (String) req.getParameter("imei");
        List<Map<String, Object>> gpsByTimeAndImei = mqttDao.getSingleGpsByTimeAndImei(imei);
        return gpsByTimeAndImei;
    }

    @RequestMapping("/getGps")
    @ResponseBody
    public List<Map<String, Object>> getGps(HttpServletRequest req) throws ParseException {
        String imei = (String) req.getParameter("imei");
        String sTime = (String) req.getParameter("sTime");
        String eTime = (String) req.getParameter("eTime");
        MqttDao mqttDao = new MqttDaoImpl();

        List<Map<String, Object>> gpsByTimeAndImei = mqttDao.getGpsByTimeAndImei(imei,sTime,eTime);
        return gpsByTimeAndImei;
    }



}
