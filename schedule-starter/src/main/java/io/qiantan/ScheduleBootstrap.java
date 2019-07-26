package io.qiantan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yujiacheng
 * @date 2019/7/264:03 PM
 */
@SpringBootApplication
@EnableScheduling
public class ScheduleBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleBootstrap.class, args);
    }
}
