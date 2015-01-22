package fr.michot.news.repositories;

import fr.michot.news.entities.PollDb;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
public interface PollRepository extends PagingAndSortingRepository<PollDb, Long> {
}
