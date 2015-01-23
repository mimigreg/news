package fr.michot.news.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Configuration
@Import({TestDataSourceConfig.class,PersistanceConfig.class,SecurityConfig.class})
@ComponentScan("fr.michot.news")
public class TestAppConfig {
}
