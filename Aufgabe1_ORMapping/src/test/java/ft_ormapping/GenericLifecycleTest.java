package ft_ormapping;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import static  org.assertj.core.api.Assertions.*;


public abstract class GenericLifecycleTest<E extends AbstractPersistable<Long>, R extends JpaRepository<E, Long>> {

    abstract R getRepository();

    abstract E createEntity();

    @Transactional
    public Long saveEntity(E entity) {
        E saved = getRepository().save(createEntity());
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        return saved.getId();
    }

    public final E readEntity(Long id) {
        E saved = getRepository().findById(id).orElse(null);
        assertThat(saved).isNotNull();
        return saved;
    }

    @Transactional
    public void updateEntity(Long id) {
        E saved = readEntity(id);
        int beforeModHash = saved.hashCode();
        saved = modifyEntity(saved);
        saveEntity(saved);
        int afterModHash = saved.hashCode();
        assertThat(beforeModHash).isNotEqualTo(afterModHash);
    }

    @Transactional
    abstract E modifyEntity(E entity);

    @Transactional
    public void deleteEntity(Long id) {
        E saved = readEntity(id);
        getRepository().delete(saved);
        assertThat(saved.getId()).isNull();
    }

    abstract void beforeDelete(E entity);

    @Test
    @Transactional
    public void verifyLifecycle() {
        long id = saveEntity(createEntity());
        E entity = readEntity(id);
        updateEntity(id);
        beforeDelete(entity);
        deleteEntity(id);
    }

}
