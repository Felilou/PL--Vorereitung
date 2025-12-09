package ft_ormapping;

import ft_ormapping.model.Person;
import ft_ormapping.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class PersonTest extends GenericLifecycleTest<Person, PersonRepository> {

    @Autowired
    PersonRepository personRepository;

    @Override
    PersonRepository getRepository() {
        return personRepository;
    }

    @Override
    Person createEntity() {
        return Person.builder()
                .firstName("Max")
                .lastName("Mustermann")
                .dateOfBirth(LocalDate.of(1980, 1, 1))
                .build();
    }

    @Override
    Person modifyEntity(Person entity) {
        entity.setFirstName("Paul");
        return entity;
    }

    @Override
    void beforeDelete(Person entity) {
        //
    }
}
