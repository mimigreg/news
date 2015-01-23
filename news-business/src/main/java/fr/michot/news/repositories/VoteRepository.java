package fr.michot.news.repositories;

import fr.michot.news.entities.VoteDb;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
public interface VoteRepository extends PagingAndSortingRepository<VoteDb, Long> {
}
