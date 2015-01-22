package fr.michot.news.api;

import fr.michot.news.config.TestAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class UserApiTest {

    @Inject
    UserApi userApi;

    @Test
    public void testSmashUser() throws Exception {
        // TODO : Coder les bons tests une fois que l'on sait ce que l'on veut faire
    }

    @Test
    public void testCreateUser() throws Exception {
        // TODO : Coder les bons tests une fois que l'on sait ce que l'on veut faire
    }

    @Test
    public void testCompleteUser() throws Exception {
        // TODO : Coder les bons tests une fois que l'on sait ce que l'on veut faire
    }

    @Test
    public void testDeleteUser() throws Exception {
        // TODO : Coder les bons tests une fois que l'on sait ce que l'on veut faire
    }

    @Test
    public void testGetUser() throws Exception {
        // TODO : Coder les bons tests une fois que l'on sait ce que l'on veut faire
    }

    @Test
    public void testFindUsers() throws Exception {
        // TODO : Coder les bons tests une fois que l'on sait ce que l'on veut faire
    }
}