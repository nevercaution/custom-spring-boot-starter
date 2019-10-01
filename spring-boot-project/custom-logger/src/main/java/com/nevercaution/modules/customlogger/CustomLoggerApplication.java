package com.nevercaution.modules.customlogger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomLoggerApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomLoggerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CustomLogService customLogService = new CustomLogService("teddy");
        customLogService.addLog("hello world!");
    }
}
