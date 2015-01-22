package fr.michot.news.repositories;

import fr.michot.news.config.TestAppConfig;
import fr.michot.news.entities.CategoryDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class CategoryRepositoryTest {
    @Inject
    CategoryRepository categoryRepository;

    @Test
    public void testCrud() {
        CategoryDb categoryDb = new CategoryDb();
        categoryDb.setName("Interne");

        categoryDb = categoryRepository.save(categoryDb);

        assertNotNull(categoryDb);
        assertNotNull(categoryDb.getCategoryId());
    }
}