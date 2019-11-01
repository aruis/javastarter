package com.aruistar.javastarter.core

import groovy.sql.Sql
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
public class JavastarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavastarterApplication.class, args);
    }

    @Bean
    Sql sql() {
        return Sql.newInstance("jdbc:postgresql://127.0.0.1:54326/ark", "postgres", "password", "org.postgresql.Driver")
    }

}
