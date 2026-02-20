package com.devops.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! DevOps learning project is running.";
    }

    @GetMapping("/status")
    public String status() {
        return "Application is healthy - Feature branch change.";
    }
}


