package fr.michot.news.repositories;

import fr.michot.news.entities.UserDb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
public interface UserRepository extends PagingAndSortingRepository<UserDb, String> {
    public Page<UserDb> findByNameContainsAndFirstNameContainsOrderByNameAsc(Pageable pageable, String name, String firstName);

    public Page<UserDb> findByUserGroupDbsUserGroupIdOrderByNameAsc(Pageable pageable, Long userGroupId);

    public Page<UserDb> findByEmail(Pageable pageable, String email);
}
