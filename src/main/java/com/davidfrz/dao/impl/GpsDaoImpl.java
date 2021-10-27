package com.davidfrz.dao.impl;

import com.davidfrz.dao.GpsDao;
import com.davidfrz.domain.Gps;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.davidfrz.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GpsDaoImpl implements GpsDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Gps> getGps(String phoneNum, String imeiNum) {
        String sql = "select * from user_gps where phone = ? and imei = ?";
        return template.query(sql,new BeanPropertyRowMapper<Gps>(Gps.class),phoneNum,imeiNum);
    }
}
