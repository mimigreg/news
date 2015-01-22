package fr.michot.news.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.beans.factory.InitializingBean;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
public class JsonObjectMapper extends ObjectMapper implements InitializingBean {
    /**
     *
     */
    private static final long serialVersionUID = 8893605026941494578L;

    public JsonObjectMapper() {
        super();
    }

    public void afterPropertiesSet() {
        registerModule(new JodaModule());
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}
