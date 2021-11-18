package com.davidfrz.s;

import com.davidfrz.ssm.bean.BrightMan;
import com.davidfrz.ssm.dao.MqttSsmDao;
import com.davidfrz.ssm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class SsmSqlTest {



    @Test
    public void testSave(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        MqttSsmDao dao = sqlSession.getMapper(MqttSsmDao.class);
        dao.saveOne("4545","12345","5454","2021-02-11 15:35:34");
    }

    @Test
    public void testGetPs() throws ParseException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        MqttSsmDao dao = sqlSession.getMapper(MqttSsmDao.class);
        List<Map<String,Object>> test = dao.getByTimeAndImei("1254", "2021-11-08 01:01:01", "2021-11-09 01:01:01");
        System.out.println(test);
        sqlSession.close();
    }

    @Test
    public void testGetOne() throws ParseException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        MqttSsmDao dao = sqlSession.getMapper(MqttSsmDao.class);
        List<Map<String,Object>> bri = dao.getOneByTimeAndImei("1254");
        System.out.println(bri);
    }

    @Test
    public void testGetOne2() throws ParseException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        MqttSsmDao dao = sqlSession.getMapper(MqttSsmDao.class);

        List<Map<String,Object>> bri = dao.getOneByTimeAndImei("1254");
        System.out.println(bri);
    }
}
