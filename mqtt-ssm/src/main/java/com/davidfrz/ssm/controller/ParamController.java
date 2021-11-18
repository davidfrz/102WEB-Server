package com.davidfrz.ssm.controller;

import com.davidfrz.ssm.bean.BrightMan;
import com.davidfrz.ssm.dao.MqttDao;
import com.davidfrz.ssm.dao.MqttSsmDao;
import com.davidfrz.ssm.dao.impl.MqttDaoImpl;
import com.davidfrz.ssm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * Date:2021/7/6
 * Author:ybc
 * Description:
 */
@Controller
public class ParamController {

//    SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    MqttSsmDao dao = sqlSession.getMapper(MqttSsmDao.class);


    @RequestMapping("/testMqtt")
    @ResponseBody
    public void testBean(@RequestBody BrightMan samp){
        String ti = (String) samp.getTim();
        dao.saveOne(samp.getImei(),
                samp.getLng(),
                samp.getLat(),
                ti);
//        MqttDao mqttDao = new MqttDaoImpl();
//        Integer rows = mqttDao.saveSamp(
//                samp.getImei(),
//                samp.getLng(),
//                samp.getLat(),
//                ti
//        );
//        System.out.println("添加成功？"+rows);
    }

    @RequestMapping("/getSinGps")
    @ResponseBody
    public List<Map<String, Object>> getSinGps(HttpServletRequest req) throws ParseException {
//        MqttDao mqttDao = new MqttDaoImpl();
        String imei = (String) req.getParameter("imei");
        List<Map<String,Object>> gpsByTimeAndImei = dao.getOneByTimeAndImei(imei);
//        List<Map<String, Object>> gpsByTimeAndImei = mqttDao.getSingleGpsByTimeAndImei(imei);
        return gpsByTimeAndImei;
    }

    @RequestMapping("/getGps")
    @ResponseBody
    public List<Map<String, Object>> getGps(HttpServletRequest req) throws ParseException {
        String imei = (String) req.getParameter("imei");
        String sTime = (String) req.getParameter("sTime");
        String eTime = (String) req.getParameter("eTime");
//        MqttDao mqttDao = new MqttDaoImpl();
        List<Map<String,Object>> gpsByTimeAndImei = dao.getByTimeAndImei(
                imei,
                sTime,
                eTime);
//        List<Map<String, Object>> gpsByTimeAndImei = mqttDao.getGpsByTimeAndImei(imei,sTime,eTime);
        return gpsByTimeAndImei;
    }



}
