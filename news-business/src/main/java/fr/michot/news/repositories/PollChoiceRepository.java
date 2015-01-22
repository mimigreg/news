package fr.michot.news.repositories;

import fr.michot.news.entities.PollChoiceDb;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
public interface PollChoiceRepository extends PagingAndSortingRepository<PollChoiceDb, Long> {
}
