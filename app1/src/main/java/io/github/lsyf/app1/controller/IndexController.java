package io.github.lsyf.app1.controller;

import io.github.lsyf.app1.dubbo.DefaultDemoService;
import io.github.lsyf.common.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

@RequestMapping
@RestController
@Slf4j
public class IndexController {

    @DubboReference(version = "1.0.0")
    DemoService demoService;

    @GetMapping("/")
    public String index() {
        log.info("开始执行逻辑");
        demoService.sayHello(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        if (ThreadLocalRandom.current().nextBoolean()) {
            log.warn("随机警告");
        }
        if (ThreadLocalRandom.current().nextBoolean()) {
            log.error("随机异常");
        }
        return TraceContext.traceId();
    }
}
