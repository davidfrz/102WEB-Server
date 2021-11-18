package com.davidfrz.service.impl;

import com.davidfrz.dao.GpsDao;
import com.davidfrz.dao.impl.GpsDaoImpl;
import com.davidfrz.domain.Gps;
import com.davidfrz.service.GpsService;
import com.davidfrz.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GpsServiceImpl implements GpsService {

    private GpsDao gpsDao = new GpsDaoImpl();

    @Override
    public List<Gps> getGps(String phoneNum,String imeiNum) {
        List<Gps> gps = gpsDao.getGps(phoneNum,imeiNum);
        return gps;
    }
}
