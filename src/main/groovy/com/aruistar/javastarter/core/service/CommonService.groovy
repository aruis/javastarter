package com.aruistar.javastarter.core.service

import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommonService {
    @Autowired
    Sql sql

    def test(){
        sql.withTransaction {

        }
    }
}
