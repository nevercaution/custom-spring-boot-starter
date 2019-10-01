package com.nevercaution.modules.pagedatabase;

import com.nevercaution.modules.pagedatabase.config.PageDatabaseJpaDataSourceTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = PageDatabaseJpaDataSourceTestConfiguration.class)
@ActiveProfiles("test")
public abstract class AbstractJpaTest {

    @Qualifier(value = "pageTestDataSource")
    @Autowired
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        if (!dataSource.getConnection().getMetaData().getURL().contains("jdbc:h2:mem")) {
            throw new IllegalArgumentException("H2 DB 가 아닙니다.");
        }
    }
}
