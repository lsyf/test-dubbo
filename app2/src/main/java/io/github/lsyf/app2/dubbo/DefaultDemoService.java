package io.github.lsyf.app2.dubbo;

import io.github.lsyf.app2.dao.bean.TPerson;
import io.github.lsyf.app2.dao.mapper.TPersonMapper;
import io.github.lsyf.common.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@DubboService(version = "1.0.0")
@Service
@Slf4j
public class DefaultDemoService implements DemoService {

    @Autowired
    TPersonMapper personMapper;
    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    public String sayHello(String name) {
        log.info("开始执行逻辑");
        log.info(name);
        if (ThreadLocalRandom.current().nextBoolean()) {
            log.warn("随机警告");
        }
        if (ThreadLocalRandom.current().nextBoolean()) {
            log.error("随机异常");
        }
        personMapper.insertSelective(TPerson.builder().name(name).build());
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}