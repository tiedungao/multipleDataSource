package com.shallbuy.transfer.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author gtd
 * description:
 * date: Create in 21:36 2019/4/15
 */
@Configuration
@ConfigurationProperties(prefix = "mybatis.old")
@MapperScan(basePackages = {"com.shallbuy.transfer.dao.old"}, sqlSessionFactoryRef = "oldSqlSessionFactory")
public class MybatisOldDataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(MybatisOldDataSourceConfig.class);

    @Resource
    @Qualifier("oldDataSource")
    private DataSource oldDataSource;
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

    @Bean(name="oldSqlSessionFactory")
    public SqlSessionFactory oldSqlSessionFactoryBean(){
        logger.info("------初始化oldSqlSessionFactory------");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        SqlSessionFactory sqlSessionFactory = null;
        bean.setDataSource(oldDataSource);
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
