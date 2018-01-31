package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 * mysql数据库连接池，定义了数据库的连接对象
 * 所有的连接都是通过这一个数据库连接对象，保证对一个数据库只有一次连接
 */
public class ManmanPool
{
    //mysql数据库的驱动程序类名称
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";

    //mysql数据库的连接地址
    private static final String DBURL = "jdbc:mysql://localhost:3306/javatest";

    //数据库的用户名
    private static final String DBUSER = "root";
    //数据库的用户密码
    private static final String PASSWORD = "";

    //连接池
    public static Connection pool = null;
    //public static Map<Connection,String> pools;

    static {
        try {
            //加载驱动
            Class.forName(DBDRIVER);

            //数据库的连接对象
            pool = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);

//            for (int i=1;i<=2;i++)
//            {
//                pools.put(DriverManager.getConnection(DBURL,DBUSER,PASSWORD),"0");
//            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
