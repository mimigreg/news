package fr.michot.news.config;

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
public class DataSourceConfig {
    @Bean
    public DataSource newsDS() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:jboss/jdbc/news");
       // return (DataSource) ctx.lookup("java:comp/env/jdbc/news");
    }
}
