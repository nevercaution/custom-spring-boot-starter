package com.nevercaution.boot.autoconfigure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = CustomLogProperties.CUSTOM_LOG_PREFIX)
public class CustomLogProperties {
    public static final String CUSTOM_LOG_PREFIX = "custom-log";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
