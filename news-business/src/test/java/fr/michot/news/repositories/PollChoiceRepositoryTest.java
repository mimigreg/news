package fr.michot.news.repositories;

import fr.michot.news.config.TestAppConfig;
import fr.michot.news.entities.PollChoiceDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class PollChoiceRepositoryTest {
    @Inject
    PollChoiceRepository pollChoiceRepository;

    @Test
    public void testCrud() {
        PollChoiceDb pollChoiceDb = new PollChoiceDb();
        pollChoiceDb.setDescription("Blabla");

        pollChoiceDb = pollChoiceRepository.save(pollChoiceDb);

        assertNotNull(pollChoiceDb);
        assertNotNull(pollChoiceDb.getPollChoiceId());
    }

}