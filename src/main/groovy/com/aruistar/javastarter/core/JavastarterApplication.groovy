package com.aruistar.javastarter.core

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.sql.Sql
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

import java.text.SimpleDateFormat

@SpringBootApplication
public class JavastarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavastarterApplication.class, args);
    }

    @Bean
    Sql sql() {
        return Sql.newInstance("jdbc:postgresql://127.0.0.1:54326/ark", "postgres", "password", "org.postgresql.Driver")
    }

    @Bean
    @Scope("prototype")
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter()
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
        jsonConverter.setObjectMapper(objectMapper)
        return jsonConverter
    }

}
