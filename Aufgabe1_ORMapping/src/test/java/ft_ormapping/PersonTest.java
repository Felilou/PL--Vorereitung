package ft_ormapping;

import ft_ormapping.model.Person;
import ft_ormapping.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest extends GenericLifecycleTest<Person, PersonRepository> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    PersonRepository getRepository() {
        return personRepository;
    }

    @Override
    Person newEntity() {
        return Person.builder()
                .firstName("test")
                .lastName("test")
                .dateOfBirth(LocalDate.of(2000, 1, 1))
                .build();
    }

    @Override
    void testRead() {
        Person p = loadFresh();

        assertThat(p)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(newEntity());

    }

    @Override
    void testUpdate() {

        Person p = loadFresh();
        p.setFirstName("test2");

        Person p2 = loadFresh();

        assertThat(p2.getId()).isEqualTo(p.getId());
        assertThat(p)
                .usingRecursiveComparison()
                .isNotEqualTo(p2);

    }

    @Override
    void testDelete() {

        Person p = loadFresh();
        personRepository.delete(p);

        assertThat(p.getId()).isNotNull();
        boolean exists = personRepository.existsById(p.getId());

        assertThat(exists).isFalse();

    }
}
