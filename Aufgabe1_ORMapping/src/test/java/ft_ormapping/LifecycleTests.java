package ft_ormapping;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public abstract class LifecycleTests {

    @Test
    abstract void testSaveEntity();

    @Test
    abstract void testReadEntity();

    @Test
    abstract void testUpdateEntity();

    @Test
    abstract void testDeleteEntity();

}


