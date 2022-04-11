package com.fuge.readwrite.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @DESCPTION: 动态数据源
 * @AUTOHR wangdingfu
 * @DATE 2022-04-11 22:25:37
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDbType();
    }
}
