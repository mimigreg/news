package fr.michot.news.repositories;

import fr.michot.news.config.TestAppConfig;
import fr.michot.news.entities.PollDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class PollRepositoryTest {
    @Inject
    PollRepository pollRepository;

    @Test
    public void testCrud() {
        PollDb pollDb = new PollDb();
        pollDb.setQuestion("Question ?");

        pollDb = pollRepository.save(pollDb);

        assertNotNull(pollDb);
        assertNotNull(pollDb.getPollId());
    }
}