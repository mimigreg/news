package fr.michot.news.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Configuration
@Import({PersistanceConfig.class,SecurityConfig.class,DataSourceConfig.class})
@ComponentScan("fr.michot.news")
public class AppConfig {
}
