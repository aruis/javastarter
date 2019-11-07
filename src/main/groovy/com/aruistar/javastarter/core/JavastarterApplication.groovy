package com.aruistar.javastarter.core

import com.alibaba.druid.pool.DruidDataSource
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.sql.Sql
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

import javax.sql.DataSource
import java.text.SimpleDateFormat

@SpringBootApplication
class JavastarterApplication {

    static void main(String[] args) {
        SpringApplication.run(JavastarterApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("app.datasource")
    DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build()
    }

    @Bean
    Sql sql() {
        return new Sql(dataSource())
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
