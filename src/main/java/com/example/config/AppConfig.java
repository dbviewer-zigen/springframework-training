package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.example.mapper.TodoMapper;

import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    // @Bean
    // public DataSource dataSource() {
    //     DriverManagerDataSource dataSource = new DriverManagerDataSource();
    //     dataSource.setDriverClassName("org.h2.Driver");
    //     dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    //     dataSource.setUsername("sa");
    //     dataSource.setPassword("");

    //     DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
    //     return dataSource;
    // }

    // private DatabasePopulator databasePopulator() {
    //     System.out.println("### -->>> Populating database");
    //     ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    //     populator.addScript(new ClassPathResource("schema.sql"));
    //     return populator;
    // }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // public SqlSessionFactory sqlSessionFactory() throws Exception {
    //     org.mybatis.spring.SqlSessionFactoryBean sqlSessionFactory = new org.mybatis.spring.SqlSessionFactoryBean();
    //     sqlSessionFactory.setDataSource(dataSource());
    //     return sqlSessionFactory.getObject();
    // }
    // @Bean
    // public TodoMapper todoMapper() throws Exception{
    //     SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
    //     return sqlSessionTemplate.getMapper(TodoMapper.class);
    // }
}
