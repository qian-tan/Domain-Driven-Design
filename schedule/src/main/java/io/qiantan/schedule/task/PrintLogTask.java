package io.qiantan.schedule.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yujiacheng
 * @date 2019/7/264:09 PM
 */
@Slf4j
@Component
@ConditionalOnProperty(value = "schedule.print.task", havingValue = "true", matchIfMissing = true)
public class PrintLogTask {

    @Scheduled(cron = "0/10 * * * * ?")
    public void print() {
        log.info("schedule print task...");
    }
}
