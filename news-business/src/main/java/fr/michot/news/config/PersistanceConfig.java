package fr.michot.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("fr.michot.news.repositories")
public class PersistanceConfig {

    @Inject
    DataSource dataSource;
    private boolean showSql = true;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setPersistenceXmlLocation("classpath:META-INF/jpa-persistence.xml");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(showSql);
        vendorAdapter.setGenerateDdl(true);

        factoryBean.setJpaVendorAdapter(vendorAdapter);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

}
