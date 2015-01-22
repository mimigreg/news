package fr.michot.news.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
@Configuration
@Import({PersistanceConfig.class,SecurityConfig.class,DataSourceConfig.class})
@ComponentScan("fr.michot.news")
public class AppConfig {
}
