package com.atguigu.mvc.dao.impl;

import com.atguigu.mvc.dao.MqttDao;
import com.atguigu.mvc.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MqttDaoImpl implements MqttDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int saveSamp(String imei, String lng, String lat, String timestamp) {
        String sql = "insert into test(imei,lng,lat,time) values(?,?,?,?)";
        int rows = template.update(sql,imei,lng,lat,timestamp);
        return rows;
    }

    /*@Override
    public Map<String, Object> getGpsByTimeAndImei(String imei, String timestamp) {
        String sql = "select * from test where imei = ? and time = ?";
//        return (Map<String, Object>) template.query(sql,new BeanPropertyRowMapper<BrightMan>(BrightMan.class),imei,timestamp);;
        return (Map<String, Object>) template.queryForMap(sql,imei,timestamp);
    }*/

    @Override
    public List<Map<String, Object>> getGpsByTimeAndImei(String imei, String timestamp,String nextDay) {

        String sql = "select * from test where imei = ? and time between ? and ?";
//        return (Map<String, Object>) template.query(sql,new BeanPropertyRowMapper<BrightMan>(BrightMan.class),imei,timestamp);;
        List<Map<String, Object>> tem = template.queryForList(sql,imei,timestamp,nextDay);
        return tem;
    }

    @Override
    public List<Map<String, Object>> getSingleGpsByTimeAndImei(String imei) throws ParseException {
        String sql = "SELECT * FROM test where time =\n" +
                "(SELECT MAX(time) as ti from test WHERE imei =?);";
//        return (Map<String, Object>) template.query(sql,new BeanPropertyRowMapper<BrightMan>(BrightMan.class),imei,timestamp);;
        List<Map<String, Object>> tem = template.queryForList(sql,imei);
        return tem;
    }
}
