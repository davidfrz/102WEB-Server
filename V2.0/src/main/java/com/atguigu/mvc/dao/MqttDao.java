package com.atguigu.mvc.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface MqttDao {
    /**
     * 保存mqttbroker传过来的相关信息
     * 保存到mysql
     * 根据项目需要这里只用到了四个部分
     * 后续可以添加设备相应的上下线时间
     * @param imei 设备号
     * @param lng 经度
     * @param lat 纬度
     * @param timestamp 时间戳
     * @return 是否保存成功
     */
    public int saveSamp(String imei, String lng, String lat, String timestamp);

    /**
     * 根据imei设备号和时间从数据库中查询数据
     * 返还信息
     * @param imei 设备号
     * @param timestamp 时间戳
     * @return 信息
     */
    public List<Map<String, Object>> getGpsByTimeAndImei(String imei, String timestamp, String nextDay) throws ParseException;

    /**
     * 查询当前位置信息（在数据库中找最近的那一个）
     * @param imei
     * @return
     * @throws ParseException
     */
    public List<Map<String, Object>> getSingleGpsByTimeAndImei(String imei) throws ParseException;


}
