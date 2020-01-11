package com.shallbuy.transfer.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author gtd
 * description:
 * date: Create in 21:36 2019/4/15
 */
@Configuration
@ConfigurationProperties(prefix = "mybatis.new")
@MapperScan(basePackages = {"com.shallbuy.transfer.dao.newer"}, sqlSessionFactoryRef = "newSqlSessionFactory")
public class MybatisNewDataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(MybatisNewDataSourceConfig.class);

    @Resource
    @Qualifier("newDataSource")
    private DataSource newDataSource;

    //类型别名
    private String typeAliasesPackage;
    //扫描Mapper地址
    private String mapperLocations;

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    @Bean(name="newSqlSessionFactory")
    public SqlSessionFactory newSqlSessionFactoryBean(){
        logger.info("------初始化newSqlSessionFactory------");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        SqlSessionFactory sqlSessionFactory = null;
        bean.setDataSource(newDataSource);
        try {
            org.springframework.core.io.Resource[] resources = new PathMatchingResourcePatternResolver()
                    .getResources(mapperLocations);
            bean.setMapperLocations(resources);
            bean.setTypeAliasesPackage(typeAliasesPackage);
            sqlSessionFactory = bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

}
