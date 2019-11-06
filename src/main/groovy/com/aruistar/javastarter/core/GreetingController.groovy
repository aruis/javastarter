package com.aruistar.javastarter.core

import com.aruistar.javastarter.core.service.CommonService
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletRequest
import java.util.concurrent.atomic.AtomicLong

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    Sql sql

    @Autowired
    CommonService commonService

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "who", defaultValue = "I") String who
    ) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name), who);
    }

    @PostMapping("/plus")
    int plus(@RequestBody def body) {
        return body.a + body.b
    }

    @GetMapping("/showHeader")
    String showHeader(@RequestHeader String myHeader) {
        return myHeader
    }

    @PostMapping("/login")
    public def login(@RequestBody Map body, HttpServletRequest request) {
        String username = (String) body.get("username");
        String password = (String) body.get("password");

        if (!username.equals("admin") || !password.equals("123456")) {
            throw new RuntimeException("用户名密码错误");
        }

        request.getSession().setAttribute("user", username)
        return [status: 200]
    }

    @GetMapping("/whoami")
    public String whoami(@SessionAttribute String user) {
        return user;
    }

    @GetMapping("/testsql")
    def testsql() {
        sql.rows("select now() as t, 1 as a union  select now()+'1 hour'::interval as t ,2 as a ")
    }

}
