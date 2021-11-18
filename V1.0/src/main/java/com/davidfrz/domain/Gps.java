package com.davidfrz.domain;

import java.io.Serializable;

public class Gps implements Serializable {
    //定义成员变量
    private String phoneNum;
    private String imeiNum;
    private String lat; // 纬度
    private String lng; // 经度

    //构造方法
    public Gps() {
    }

    public Gps(String phoneNum, String imeiNum, String lat, String lng) {
        this.phoneNum = phoneNum;
        this.imeiNum = imeiNum;
        this.lat = lat;
        this.lng = lng;
    }

    //getter setter
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getImeiNum() {
        return imeiNum;
    }

    public void setImeiNum(String imeiNum) {
        this.imeiNum = imeiNum;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Gps{" +
                "phoneNum='" + phoneNum + '\'' +
                ", imeiNum='" + imeiNum + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
