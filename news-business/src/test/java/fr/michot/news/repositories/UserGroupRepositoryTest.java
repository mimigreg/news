package fr.michot.news.repositories;

import fr.michot.news.config.TestAppConfig;
import fr.michot.news.entities.UserGroupDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class UserGroupRepositoryTest {
    @Inject
    UserGroupRepository userGroupRepository;

    @Test
    public void testCrud() {
        UserGroupDb userGroupDb = new UserGroupDb();
        userGroupDb.setGroupName("Administrateurs");

        userGroupDb = userGroupRepository.save(userGroupDb);

        assertNotNull(userGroupDb);
        assertNotNull(userGroupDb.getUserGroupId());
    }

}