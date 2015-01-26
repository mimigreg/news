package fr.michot.news.repositories;

import fr.michot.news.config.TestAppConfig;
import fr.michot.news.entities.UserDb;
import fr.michot.news.entities.UserGroupDb;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class UserRepositoryTest {
    @Inject
    UserRepository userRepository;

    @Inject
    UserGroupRepository userGroupRepository;

    // Used for dataset...
    UserGroupDb userGroupDb1;

    @Before
    @Transactional
    public void setUpDataset () {
        userGroupDb1 = new UserGroupDb();
        userGroupDb1.setGroupName("users");
        userGroupDb1 = userGroupRepository.save(userGroupDb1);
        Set<UserGroupDb> userGroupDbs1 = new HashSet<>();
        userGroupDbs1.add(userGroupDb1);

        UserGroupDb userGroupDb2 = new UserGroupDb();
        userGroupDb2.setGroupName("admins");
        userGroupRepository.save(userGroupDb2);
        Set<UserGroupDb> userGroupDbs2 = new HashSet<>();
        userGroupDbs2.add(userGroupDb2);

        UserDb userDb = new UserDb();
        userDb.setEmail("mimigreg@gmail.com");
        userDb.setFirstName("Mimi");
        userDb.setName("Greg");
        userDb.setPass("pa$$");
        userDb.setUserGroupDbs(userGroupDbs2);
        userDb = userRepository.save(userDb);

        UserDb userDb1 = new UserDb();
        userDb1.setEmail("user1@user.com");
        userDb1.setFirstName("user1");
        userDb1.setName("user1");
        userDb1.setPass("user1");
        userDb1.setUserGroupDbs(userGroupDbs1);
        userDb1 = userRepository.save(userDb1);

        UserDb userDb2 = new UserDb();
        userDb2.setEmail("user2@user.com");
        userDb2.setFirstName("user2");
        userDb2.setName("user2");
        userDb2.setPass("user2");
        userDb2.setUserGroupDbs(userGroupDbs1);
        userDb2 = userRepository.save(userDb2);
    }

    @Test
    @Transactional
    public void findByNameContainsAndFirstNameContainsOrderByNameAsc() throws Exception {
        Page<UserDb>userDbs = userRepository.findByNameContainsAndFirstNameContainsOrderByNameAsc(null, "G", "M");
        assertNotNull(userDbs);
        assertEquals(1, userDbs.getNumberOfElements());
    }

    @Test
    @Transactional
    public void findByUserGroupDbsUserGroupIdOrderByNameAsc() throws Exception {
        Page<UserDb>userDbs = userRepository.findByUserGroupDbsUserGroupIdOrderByNameAsc(null, userGroupDb1.getUserGroupId());
        assertNotNull(userDbs);
        assertEquals(2, userDbs.getNumberOfElements());
    }
}