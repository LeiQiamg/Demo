package com.hello.demo.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 从库配置
 * @author leiqiang
 * @date 2021/5/6
 */
@Configuration
//@Component
@MapperScan(basePackages = "com.hello.demo.entity.slave", sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveMybatisConfig {

    @Autowired
    @Qualifier("slave")
    private DataSource dataSource;

    @Bean("slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory() throws Exception {
        //设置数据源
        MybatisSqlSessionFactoryBean slaveSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        slaveSqlSessionFactoryBean.setDataSource(dataSource);
        //设置mapper.xml文件扫描路径
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver =
            new PathMatchingResourcePatternResolver();
        slaveSqlSessionFactoryBean
            .setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath*:/mapper/slave/*.xml"));
        //设置entity扫描路径
        String typeAliasesPackage = "com.hello.demo.entity.slave";
        slaveSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return slaveSqlSessionFactoryBean.getObject();
    }


}
