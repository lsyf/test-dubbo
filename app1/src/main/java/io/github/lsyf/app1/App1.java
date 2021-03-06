package io.github.lsyf.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class App1 {

    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }

}
