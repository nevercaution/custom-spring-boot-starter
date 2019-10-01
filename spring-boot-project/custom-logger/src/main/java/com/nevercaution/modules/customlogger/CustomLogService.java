package com.nevercaution.modules.customlogger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;

@Slf4j
public class CustomLogService {

    private String name;

    public CustomLogService(String name) {
        this.name = name;
    }

    public void addLog(String message) {
        addLog(message, LogLevel.INFO);
    }

    public void addLog(String message, LogLevel logLevel) {
        switch(logLevel) {
            case INFO:
                log.info("{}, custom Log. {}, {} ", logLevel, name, message);
                break;
            case DEBUG:
                log.debug("{}, custom Log. {}, {} ", logLevel, name, message);
            default:
                log.warn("invalid log level!, {}", logLevel);
        }
    }
}
