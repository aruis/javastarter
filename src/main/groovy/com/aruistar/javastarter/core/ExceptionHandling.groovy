package com.aruistar.javastarter.core

import groovy.util.logging.Slf4j
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@Slf4j
@ControllerAdvice
class ExceptionHandling {

    @ExceptionHandler(Exception.class)
    def exception(Exception exception) {
        log.info(exception.message)

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","text/plain;charset=UTF-8")

        return new ResponseEntity(exception.getMessage().getBytes("UTF-8"), headers, 516)
    }

}
