package com.nevercaution.boot.autoconfigure.config.log;


import com.nevercaution.modules.customlogger.CustomLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({CustomLogService.class})
@ConditionalOnProperty(prefix = "custom-log", name = {"name"})
@EnableConfigurationProperties(CustomLogProperties.class)
public class CustomLogConfiguration {

    @Autowired
    private CustomLogProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public CustomLogService customLogService() {
        return new CustomLogService(properties.getName());
    }
}
