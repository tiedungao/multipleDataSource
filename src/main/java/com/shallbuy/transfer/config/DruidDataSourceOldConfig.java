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
import java.sql.SQLException;

/**
 * @author gtd
 * description:
 * date: Create in 9:31 2019/4/13
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceOldConfig {

    @Bean("oldDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.old")
    public DataSource dataSource() {
        return  new DruidDataSource();
    }

    @Bean("oldTransactionManager")
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(this.dataSource());
        return dataSourceTransactionManager;
    }

}
