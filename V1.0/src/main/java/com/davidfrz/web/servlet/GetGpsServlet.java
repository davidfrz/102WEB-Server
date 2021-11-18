package com.davidfrz.web.servlet;

import com.alibaba.fastjson.JSON;
import com.davidfrz.domain.Gps;
import com.davidfrz.service.GpsService;
import com.davidfrz.service.impl.GpsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/getGps")
public class GetGpsServlet extends HttpServlet {

    private GpsService gpsservice = new GpsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter out = resp.getWriter();

        System.out.println("post访问到了");
//        String phoneNum = req.getParameter("phoneNum");
//        String imeiNum = req.getParameter("imeiNum");
//
//        List<Gps> gps = gpsservice.getGps(phoneNum, imeiNum);
//        System.out.println(gps);

        try{
            String phoneNum = req.getParameter("phoneNum");
            String imeiNum = req.getParameter("imeiNum");

            List<Gps> gps = gpsservice.getGps(phoneNum, imeiNum);
            Map<String, Object> resM = new HashMap<>();
            resM.put("phoneNum",phoneNum);
            resM.put("imeiNum",imeiNum);
            resM.put("lng",gps.get(0).getLng());
            resM.put("lat",gps.get(0).getLat());
            String resJson = JSON.toJSONString(resM);

            out.print(resJson);
        } catch (Exception e){
            out.print("数据错误");
            e.printStackTrace();
        }
//        writeValue(gps,resp);

    }
}
