package fr.michot.news.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Configuration
public class TestDataSourceConfig {
    @Bean
    public DataSource newsDS() throws Exception {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        basicDataSource.setUrl("jdbc:derby:memory:newsDB;create=true");
        basicDataSource.setPassword("app");
        basicDataSource.setUsername("app");
        return basicDataSource;
    }
}
