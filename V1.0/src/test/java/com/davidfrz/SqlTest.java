package com.davidfrz;

import com.davidfrz.dao.GpsDao;
import com.davidfrz.dao.impl.GpsDaoImpl;
import com.davidfrz.domain.Gps;
import com.davidfrz.service.impl.GpsServiceImpl;
import org.junit.Test;

import java.util.List;

public class SqlTest {
    @Test
    public void getGps() {
        GpsDao gpsDao = new GpsDaoImpl();
//        List<Gps> gps = gpsDao.getGps("15613323375", "12345");
        List<Gps> gps = gpsDao.getGps("15613323375", "12345");
        System.out.println(gps.get(0).getLat());
    }

    @Test
    public void get(){
        GpsServiceImpl gpsService = new GpsServiceImpl();
        List<Gps> gps = gpsService.getGps("15613323375", "12345");
        System.out.println(gps);
    }
}
