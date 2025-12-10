package ft_ormapping;

import ft_ormapping.model.Person;
import ft_ormapping.model.Teacher;
import ft_ormapping.model.TeacherIdentifier;
import ft_ormapping.repositories.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class TeacherTest extends GenericLifecycleTest<Teacher, TeacherRepository> {

    @Autowired
    TeacherRepository TeacherRepository;

    @Override
    TeacherRepository getRepository() {
        return TeacherRepository;
    }

    @Override
    Teacher newEntity() {

        Person person = Person.builder()
                .firstName("Paul")
                .lastName("Berlin")
                .dateOfBirth(LocalDate.of(1980, 1, 1))
                .build();

        return Teacher.teacherBuilder()
                .person(person)
                .identifier("HUB210654")
                .build();
    }

    @Override
    void testRead() {

    }

    @Override
    void testUpdate() {

    }

    @Override
    void testDelete() {

    }

    @Test
    public void testRelation() {
        Teacher t = loadFresh();
    }
}
