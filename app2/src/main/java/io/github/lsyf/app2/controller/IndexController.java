package io.github.lsyf.app2.controller;

import io.github.lsyf.app2.dubbo.DefaultDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequestMapping
@RestController
public class IndexController {

    @Autowired
    DefaultDemoService demoService;

    @GetMapping("/")
    public String index() {

        return demoService.sayHello(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
