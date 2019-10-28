package com.aruistar.javastarter.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TimeController {

    @RequestMapping("/now")
    public Date now() {
        return new Date();
    }
}
