package com.davidfrz.ssm.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class BrightMan implements Serializable {

    private Integer id;
    private String imei;
    private String lng;
    private String lat;
    private String tim;

    public BrightMan() {
    }

    public BrightMan(Integer id, String imei, String lng, String lat, String tim) {
        this.id = id;
        this.imei = imei;
        this.lng = lng;
        this.lat = lat;
        this.tim = tim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    @Override
    public String toString() {
        return "BrightMan{" +
                "id=" + id +
                ", imei='" + imei + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", tim='" + tim + '\'' +
                '}';
    }
}
