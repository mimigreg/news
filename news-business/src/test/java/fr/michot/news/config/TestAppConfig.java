package fr.michot.news.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
@Configuration
@Import({TestDataSourceConfig.class,PersistanceConfig.class,SecurityConfig.class})
@ComponentScan("fr.michot.news")
public class TestAppConfig {
}
