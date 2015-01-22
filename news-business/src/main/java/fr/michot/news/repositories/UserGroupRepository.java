package fr.michot.news.repositories;

import fr.michot.news.entities.UserGroupDb;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
public interface UserGroupRepository extends PagingAndSortingRepository<UserGroupDb, Long> {
}
