package io.qiantan.schedule.api;

import io.qiantan.schedule.task.PrintLogTask;
import io.qiantan.schedule.task.ReadUserTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yujiacheng
 * @date 2019/7/264:36 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/schedule")
@Api(description = "任务管理")
public class ScheduleApi {

    private PrintLogTask printLogTask;
    private ReadUserTask readUserTask;

    @Autowired
    @Lazy
    public ScheduleApi(PrintLogTask printLogTask, ReadUserTask readUserTask) {
        this.printLogTask = printLogTask;
        this.readUserTask = readUserTask;
    }

    @ApiOperation("打印任务")
    @GetMapping("/print/task")
    public void printLogTask() {
        printLogTask.print();
    }

    @ApiOperation("读取任务")
    @GetMapping("/read/task")
    public void readUserTask() {
        readUserTask.read();
    }

}
