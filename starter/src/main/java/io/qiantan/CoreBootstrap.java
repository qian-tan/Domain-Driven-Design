package io.qiantan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:11 PM
 */
@SpringBootApplication
public class CoreBootstrap {

    /**
     * Spring boot Main
     */
    public static void main(String[] args) {
        new SpringApplication(CoreBootstrap.class).run(args);
    }
}
