package com.davidfrz.dao;

import com.davidfrz.domain.Gps;

import java.util.List;


public interface GpsDao {
    /**
     * 根据上传的电话号码与设备imei，查询对应的经纬度Gps信息（没有加上时间）
     * @param phoneNum
     * @param imeiNum
     * @return
     */
    public List<Gps> getGps(String phoneNum,String imeiNum);
}
