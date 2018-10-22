package com.edgardeng.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = OracleDatasourceConfig.PACKAGE, sqlSessionFactoryRef = "oracleSessionFactory")
public class OracleDatasourceConfig {

    // mysqldao扫描路径
    static final String PACKAGE = "com.edgardeng.oracle.dao";
    // mybatis mapper扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/oracle/*.xml";

    @Bean
    @Qualifier("oracle")
    @ConfigurationProperties("spring.datasource.hikari.oracle")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "oracleTransactionManager")
    public DataSourceTransactionManager oracleTransactionManager() {
        return new DataSourceTransactionManager(oracleDataSource());
    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Primary
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Value("${mybatis.mapper-locations}") String mapperLocations,
//                                               @Value("${mybatis.type-aliases-package}")String typeAliasesPackage) throws Exception {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(mysqlDataSource());
//        // mapperLocationsmysql
//        logger.error("sqlSessionFactory");
//        logger.error(mapperLocations);
//        logger.error(typeAliasesPackage);
//        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
//        sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
//        return sessionFactoryBean.getObject();
//    }

    @Bean(name = "oracleSessionFactory")
    public SqlSessionFactory oracleSessionFactory(@Qualifier("oracle") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(OracleDatasourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}