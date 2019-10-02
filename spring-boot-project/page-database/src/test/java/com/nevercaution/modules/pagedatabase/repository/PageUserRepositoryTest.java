package com.nevercaution.modules.pagedatabase.repository;

import com.nevercaution.modules.pagedatabase.AbstractJpaTest;
import com.nevercaution.modules.pagedatabase.model.PageUser;
import com.nevercaution.modules.pagedatabase.model.UserStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PageUserRepositoryTest extends AbstractJpaTest {

    @Autowired
    private PageUserRepository pageUserRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void insertTest() {
        PageUser pageUser = new PageUser();
        pageUser.setName("name");
        pageUser.setPhone("11112222333");
        pageUser.setUserStatus(UserStatus.READY);

        pageUserRepository.saveAndFlush(pageUser);

        entityManager.clear();
        entityManager.flush();

        Optional<PageUser> pageUserOptional = pageUserRepository.findByName(pageUser.getName());
        assertThat(pageUserOptional.isPresent()).isTrue();

        PageUser findUser = pageUserOptional.get();
        assertThat(findUser).isNotNull();
//        assertThat(findUser.getCreateDt()).isNotNull();
    }

}