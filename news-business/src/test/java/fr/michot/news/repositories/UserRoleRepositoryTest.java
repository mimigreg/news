package fr.michot.news.repositories;

import fr.michot.news.config.TestAppConfig;
import fr.michot.news.entities.UserGroupDb;
import fr.michot.news.entities.UserRoleDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class UserRoleRepositoryTest {
    @Inject
    UserRoleRepository userRoleRepository;

    @Test
    public void testCrud() {
        UserRoleDb userRoleDb = new UserRoleDb();
        userRoleDb.setRoleName("ADMIN");

        userRoleDb = userRoleRepository.save(userRoleDb);

        assertNotNull(userRoleDb);
        assertNotNull(userRoleDb.getUserRoleId());
    }

}