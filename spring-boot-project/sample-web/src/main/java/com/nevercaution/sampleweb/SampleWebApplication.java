package com.nevercaution.sampleweb;

import com.nevercaution.modules.customlogger.CustomLogService;
import com.nevercaution.modules.pagedatabase.model.PageUser;
import com.nevercaution.modules.pagedatabase.repository.PageUserRepository;
import com.nevercaution.modules.pagedatabase.service.PageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LogLevel;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SampleWebApplication implements ApplicationRunner {

    @Autowired
    private CustomLogService customLogService;

    @Autowired
    private PageUserService pageUserService;

    @Autowired
    private PageUserRepository pageUserRepository;

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SampleWebApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List.of(context.getBeanDefinitionNames()).forEach(b -> {
            System.out.println("bean name : " + b);
        });

        customLogService.addLog("hello log!", LogLevel.INFO);

        pageUserService.addUser("teddy", "12345");

        pageUserService.changePhone("teddy", "45683868");

        Optional<PageUser> pageUserOptional = pageUserRepository.findByName("teddy");

        pageUserOptional.ifPresent(System.out::println);
    }
}
