package fr.michot.news.repositories;

import fr.michot.news.entities.NewsDb;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
public interface NewsRepository extends PagingAndSortingRepository<NewsDb, Long> {
}
