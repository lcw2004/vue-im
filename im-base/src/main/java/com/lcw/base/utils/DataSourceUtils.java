package com.lcw.base.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

public class DataSourceUtils {

    /**
     * 创建数据源（Druid连接池）
     * @param env
     * @return
     */
    public static DataSource createDruidDataSource(Environment env) {
        return createDruidDataSource(env, "spring.datasource");
    }

    /**
     * 创建数据源（Druid连接池）
     * @param env
     * @param prefix 前缀
     * @return
     */
    public static DataSource createDruidDataSource(Environment env, String prefix) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty(prefix + ".driver-class-name"));
        dataSource.setUrl(env.getProperty(prefix + ".url"));
        dataSource.setUsername(env.getProperty(prefix + ".username"));
        dataSource.setPassword(env.getProperty(prefix + ".password"));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty(prefix + ".druid.initial-size")));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty(prefix + ".druid.max-active")));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty(prefix + ".druid.min-idle")));
        dataSource.setMaxWait(Integer.parseInt(env.getProperty(prefix + ".druid.max-wait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(env.getProperty(prefix + ".druid.time-between-eviction-runs-millis")));
        dataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(env.getProperty(prefix + ".druid.min-evictable-idle-time-millis")));
        dataSource.setValidationQuery(env.getProperty(".druid.validation-query"));
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(60*60); // 超过一个小时回收连接
        dataSource.setLogAbandoned(true); // 查看超时的日志，以供查看什么代码里面占用了连接
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        dataSource.setTestOnReturn(false);
        return dataSource;
    }

}
