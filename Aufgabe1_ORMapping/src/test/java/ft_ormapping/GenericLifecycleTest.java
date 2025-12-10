package ft_ormapping;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

@DataJpaTest
public abstract class GenericLifecycleTest<E extends AbstractPersistable<Long>, R extends JpaRepository<E, Long>> {



}
