package com.davidfrz.service;

import com.davidfrz.domain.Gps;

import java.util.List;


public interface GpsService {
    /**
     * 根据手机号码和imei查询相应数据
     * @param phoneNum
     * @param imeiNum
     * @return
     */
    public List<Gps> getGps(String phoneNum,String imeiNum);
}
