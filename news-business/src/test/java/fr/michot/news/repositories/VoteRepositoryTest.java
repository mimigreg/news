package fr.michot.news.repositories;

import fr.michot.news.config.TestAppConfig;
import fr.michot.news.entities.VoteDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class VoteRepositoryTest {
    @Inject
    VoteRepository voteRepository;

    @Test
    public void testCrud() {
        VoteDb voteDb = new VoteDb();
        voteDb.setDate(new Date());

        voteDb = voteRepository.save(voteDb);

        assertNotNull(voteDb);
        assertNotNull(voteDb.getVoteId());
    }

}