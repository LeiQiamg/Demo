package com.hello.demo.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/**
 * mybatis使用pageHelp分页插件配置
 * @author leiqiang
 * @date 2021/4/25
 */
@Configuration
//@MapperScan("com.hello.demo.**.*")
//@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class MybatisPlusConfig {

/*    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }*/

    @Primary
    @Bean("master")
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterPrimaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("slave")
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slavePrimaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置sqlsessionFactory
     * @return
     */
//    @Bean
//    public SqlSessionFactory masterPrimarySqlSessionFactory() {
//        SqlSessionFactory sqlSessionFactory = null;
//        try {
//            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//            sqlSessionFactoryBean.setDataSource(masterPrimaryDataSource());
//            sqlSessionFactoryBean
//                .setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis-primary.xml"));
//            sqlSessionFactoryBean
//                .setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*:/mapper/master/*.xml"));
//            sqlSessionFactory = sqlSessionFactoryBean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sqlSessionFactory;
//    }

    /**
     * @return
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactory(masterPrimarySqlSessionFactory());
//        //每张表对应的*.java,interface类型的Java文件
//        mapperScannerConfigurer.setBasePackage("com.hello.demo.mapper");
//        return mapperScannerConfigurer;
//    }
}
