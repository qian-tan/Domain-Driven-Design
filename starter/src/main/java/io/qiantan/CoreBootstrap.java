package io.qiantan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:11 PM
 */
@EnableCaching
@SpringBootApplication
public class CoreBootstrap {

    /**
     * Spring boot Main
     */
    public static void main(String[] args) {
        new SpringApplication(CoreBootstrap.class).run(args);
    }
}
