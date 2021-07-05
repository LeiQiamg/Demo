package com.hello.demo.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 主库数据源
 * @author leiqiang
 * @date 2021/4/29
 */
@Configuration
//@Component
@MapperScan(basePackages = "com.hello.demo.entity.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterMybatisConfig {

    @Autowired
    @Qualifier("master")
    private DataSource dataSource;

    @Primary
    @Bean("masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory() throws Exception {
        //设置数据源
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        //mapper的xml文件的位置
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver =
            new PathMatchingResourcePatternResolver();
        String localPath = "classpath:/mapper/master/*.xml";
        mybatisSqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(localPath));
        //对应数据库的entity的位置
        String typeAliasesPackage = "com.hello.demo.entity.master";
        mybatisSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return mybatisSqlSessionFactoryBean.getObject();
    }
}
