package com.nevercaution.modules.pagedatabase.service;

import com.nevercaution.modules.pagedatabase.model.PageUser;
import com.nevercaution.modules.pagedatabase.model.UserStatus;
import com.nevercaution.modules.pagedatabase.repository.PageUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class PageUserService {

    private PageUserRepository pageUserRepository;

    @Autowired
    public PageUserService(PageUserRepository pageUserRepository) {
        this.pageUserRepository = pageUserRepository;
    }

    public PageUser addUser(String name, String phone) {
        PageUser pageUser = new PageUser();
        pageUser.setName(name);
        pageUser.setPhone(phone);
        pageUser.setUserStatus(UserStatus.NORMAL);

        return addUser(pageUser);
    }

    @Transactional
    public PageUser addUser(PageUser pageUser) {
        log.info("pageUser : " + pageUser);
        PageUser saveUser = pageUserRepository.save(pageUser);
        return saveUser;
    }

    @Transactional
    public void changePhone(String name, String phone) {
        log.info("find by name : " + name + ", and modify phone " + phone);

        Optional<PageUser> findUserOptional = pageUserRepository.findByName(name);
        findUserOptional.ifPresent(pageUser -> {
            log.info("find user : " + pageUser);
            pageUser.setPhone(phone);

            pageUserRepository.save(pageUser);
        });
    }
}
