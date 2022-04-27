package io.github.lsyf.common;

import org.apache.dubbo.config.annotation.DubboReference;

public interface DemoService {

    String sayHello(String name);
}