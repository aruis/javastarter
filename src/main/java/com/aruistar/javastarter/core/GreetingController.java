package com.aruistar.javastarter.core;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "who", defaultValue = "I") String who
    ) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name), who);
    }

    @PostMapping("/plus")
    public int plus(@RequestBody Map body) {
        int a = (int) body.get("a");
        int b = (int) body.get("b");
        return a + b;
    }

}
