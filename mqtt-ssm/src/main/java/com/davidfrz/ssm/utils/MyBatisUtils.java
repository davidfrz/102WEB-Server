package com.davidfrz.ssm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private  static SqlSessionFactory factory = null;
    static {
        String config="mybatis.xml"; // 需要和你的项目中的文件名一样
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象，使用SqlSessionFactoryBuild
        factory = new SqlSessionFactoryBuilder().build(in);

    }


    //获取SqlSession的方法
    public static SqlSession getSqlSession() {
        SqlSession sqlSession  = null;
        if( factory != null){
            // 自动提交事务
            sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }
}
