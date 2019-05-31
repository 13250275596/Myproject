package com.example.myproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@EnableScheduling
public class mainController {
    private static Logger log = LoggerFactory.getLogger(mainController.class);
    int test = 0;

    @Transactional
    @Scheduled(cron = "0/3 * * * * ?")
    public void requestMethodName() {
        log.info("————定时任务开始执行————");
        System.out.println(test++);
        log.info("————定时任务执行成功————");
        return;
    }

}
