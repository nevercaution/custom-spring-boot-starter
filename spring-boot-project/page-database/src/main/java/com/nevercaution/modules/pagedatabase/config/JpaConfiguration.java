package com.nevercaution.modules.pagedatabase.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
//@EnableAutoConfiguration
@ComponentScan("com.nevercaution.modules.pagedatabase")
public class JpaConfiguration {
}
