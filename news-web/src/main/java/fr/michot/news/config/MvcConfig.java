package fr.michot.news.config;

import fr.michot.news.json.JsonObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
@Configuration
@EnableWebMvc
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@ComponentScan("fr.michot.news")
@EnableTransactionManagement
public class MvcConfig extends WebMvcConfigurerAdapter {
    private <T> List<T> buildList(T element) {
        List<T> l = new ArrayList<T>();
        l.add(element);
        return l;
    }

    @Bean
    public JsonObjectMapper jacksonObjectMapper() {
        return new JsonObjectMapper();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.setSupportedMediaTypes(buildList(MediaType.APPLICATION_JSON));
        jacksonConverter.setObjectMapper(jacksonObjectMapper());
        jacksonConverter.setJsonPrefix(")]}',\n");
        converters.add(jacksonConverter);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
    }

}
