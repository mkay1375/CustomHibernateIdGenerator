package ir.mkay.customidgenerator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SomeEntityRepositoryTest {

    @Autowired
    private SomeEntityRepository someEntityRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testEntityWithNullIdSaved() {
        var entity = new SomeEntity();
        var savedEntity = someEntityRepository.saveAndFlush(entity);
        log.info("Entity saved with id: {}", savedEntity.getId());
        assertNotNull(savedEntity.getId());
    }

    @Test
    public void testEntityWithSpecifiedIdSaved() {
        final var id = 2000;
        var entity = new SomeEntity();
        entity.setId(id);
        var savedEntity = someEntityRepository.saveAndFlush(entity);
        log.info("Entity saved with id: {}", savedEntity.getId());
        assertEquals(id, savedEntity.getId());
    }

    @Test
    public void testEntityWithSpecifiedIdUpdates() {
        final var id = 3000;
        var entity = new SomeEntity();
        entity.setId(id);
        entity.setSomeField("saving");
        someEntityRepository.saveAndFlush(entity);
        entityManager.detach(entity);
        var savedEntity = someEntityRepository.findById(id).get();
        savedEntity.setSomeField("updated");
        someEntityRepository.save(savedEntity);
        entityManager.detach(savedEntity);
        var updatedEntity = someEntityRepository.findById(id).get();
        assertEquals(id, updatedEntity.getId());
        assertEquals("updated", updatedEntity.getSomeField());
    }


}
