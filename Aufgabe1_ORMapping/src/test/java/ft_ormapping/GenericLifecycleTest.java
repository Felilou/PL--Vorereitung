package ft_ormapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public abstract class GenericLifecycleTest<E extends AbstractPersistable<Long>, R extends JpaRepository<E, Long>> {

    abstract R getRepository();
    abstract E newEntity();

    @Autowired
    EntityManager entityManager;

    private Long savedId;

    @BeforeEach
    @Transactional
    void testCreate() {
        E saved = getRepository().saveAndFlush(newEntity());
        savedId = saved.getId();
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        entityManager.clear();
    }

    protected E loadFresh() {
        entityManager.clear();
        return getRepository().findById(savedId).orElseThrow(EntityNotFoundException::new);
    }

    abstract void testRead();

    abstract void testUpdate();

    abstract void testDelete();

    @Nested
    class verify_lifecycle{

        @Test
        void test_read() {
            testRead();
        }

        @Test
        void test_update() {
            testUpdate();
        }

        @Test
        void test_delete() {
            testDelete();
        }

    }
}
