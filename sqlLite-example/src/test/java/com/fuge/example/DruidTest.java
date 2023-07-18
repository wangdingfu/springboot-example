package com.fuge.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.system.SystemUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wangdingfu
 * @date 2023-07-18 16:47:34
 */
public class DruidTest {


    //驱动类的完全限定名
    private static final String DRIVE_NAME = "org.sqlite.JDBC";

    //数据库的路径
    private static final String DB_URL = "jdbc:sqlite:\\C:\\Users\\fuge\\Desktop\\test.db";



    /**
     * 硬编码使用druid
     */
    @Test
    public void test() throws SQLException {
        //1.创建druid连接池对象
        DruidDataSource dataSource = new DruidDataSource();

        //2.设置连接池参数   必须设置的参数
        dataSource.setUrl(DB_URL);
        dataSource.setDriverClassName(DRIVE_NAME);
        // 初始化连接池数量
        // 最大连接数量
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        DruidPooledConnection connection = dataSource.getConnection();
        String sql = "select * from test where id = 1;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println(id + " " + name + " " + age);
        }
        connection.close();
    }

}
