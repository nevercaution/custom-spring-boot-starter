package com.nevercaution.modules.pagedatabase.repository;

import com.nevercaution.modules.pagedatabase.model.PageUser;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface PageUserRepository extends JpaRepositoryImplementation<PageUser, Long> {
    Optional<PageUser> findByName(String name);
}
