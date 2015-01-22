package fr.michot.news.repositories;

import fr.michot.news.entities.CategoryDb;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
public interface CategoryRepository extends PagingAndSortingRepository<CategoryDb, Long> {
}
