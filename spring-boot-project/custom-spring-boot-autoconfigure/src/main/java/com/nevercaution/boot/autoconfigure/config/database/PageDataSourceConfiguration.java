package com.nevercaution.boot.autoconfigure.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.nevercaution.modules.pagedatabase")
@EnableJpaRepositories(basePackages = {
        // TODO: add repository package name in custom database modules
        "com.nevercaution.modules.pagedatabase.repository",
})
@ConditionalOnMissingBean(DataSource.class)
@ConditionalOnClass({JpaRepository.class})
@EnableConfigurationProperties(PageDataSourceProperties.class)
@EnableTransactionManagement
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@ConditionalOnProperty(prefix = "custom.datasource", name = {"username", "password", "url", "hibernateDialect"}, matchIfMissing = true)
public class PageDataSourceConfiguration {

    private static final String[] ENTITY_PACKAGES = {
            // TODO: add model package name in custom database modules
            "com.nevercaution.modules.pagedatabase.model"
    };

    @Bean(destroyMethod = "close")
    @ConditionalOnMissingBean
    DataSource dataSource(PageDataSourceProperties properties) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl(properties.getUrl());
        config.setUsername(properties.getUsername());
        config.setPassword(properties.getPassword());

        return new HikariDataSource(config);
    }

    @Bean("entityManagerFactory")
    @ConditionalOnMissingBean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, PageDataSourceProperties properties) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);


//        HibernateProperties hibernateProperties = new HibernateProperties();
        Properties jpaProperties = new Properties();
        jpaProperties.put(Environment.HBM2DDL_AUTO, "create");
        jpaProperties.put("hibernate.dialect", properties.getHibernateDialect());
        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.format_sql", true);

        // TODO: put jpa properties
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
