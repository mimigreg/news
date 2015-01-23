package fr.michot.news.repositories;

import fr.michot.news.entities.UserGroupDb;
import fr.michot.news.entities.UserRoleDb;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
public interface UserRoleRepository extends PagingAndSortingRepository<UserRoleDb, Long> {
}
