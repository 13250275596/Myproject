package com.example.myproject.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@EnableScheduling
public class mainController {

    int test = 0;

    @Transactional
    @Scheduled(cron = "0/3 * * * * ?")
    public void requestMethodName() {
        System.out.println(test++);
        return;
    }

}
