package com.fuge.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fuge.example.mapper.StudentMapper;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author wangdingfu
 * @date 2023-07-18 17:32:15
 */
public class MybatisPlusConfig {


    private static final String DRIVE_NAME = "org.sqlite.JDBC";

    private static final String DB_URL = "jdbc:sqlite:\\C:\\Users\\fuge\\Desktop\\test.db";

    private static final SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();

    public static <T, R extends BaseMapper<T>> void execute(Class<R> clazz, Consumer<R> consumer) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            consumer.accept(session.getMapper(clazz));
        }
    }


    public static SqlSessionFactory initSqlSessionFactory() {
        DataSource dataSource = dataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("Production", transactionFactory, dataSource);
        MybatisConfiguration configuration = new MybatisConfiguration(environment);
        configuration.addMappers("com.fuge.example.mapper");
        configuration.setLogImpl(StdOutImpl.class);
        return new MybatisSqlSessionFactoryBuilder().build(configuration);
    }


    private static DataSource dataSource() {
        //1.创建druid连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        //2.设置连接池参数   必须设置的参数
        dataSource.setUrl(DB_URL);
        dataSource.setDriverClassName(DRIVE_NAME);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }
}
