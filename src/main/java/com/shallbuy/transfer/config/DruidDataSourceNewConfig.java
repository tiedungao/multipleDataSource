package com.shallbuy.transfer.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author gtd
 * description:
 * date: Create in 9:31 2019/4/13
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceNewConfig {

    /**
     * 数据源配置
     * @return
     */
    @Bean("newDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.new")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * 事务管理
     * @return
     */
    @Bean("newTransactionManager")
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(this.dataSource());
        return dataSourceTransactionManager;
    }

}
