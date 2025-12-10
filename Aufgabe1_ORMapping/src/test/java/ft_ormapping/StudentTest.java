package ft_ormapping;

import ft_ormapping.model.Person;
import ft_ormapping.model.Student;
import ft_ormapping.model.StudentIdentifier;
import ft_ormapping.repositories.PersonRepository;
import ft_ormapping.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class StudentTest extends GenericLifecycleTest<Student, StudentRepository> {

    @Autowired
    StudentRepository studentRepository;

    @Override
    StudentRepository getRepository() {
        return studentRepository;
    }

    @Override
    Student newEntity() {

        Person person = Person.builder()
                .firstName("Paul")
                .lastName("Berlin")
                .dateOfBirth(LocalDate.of(1980, 1, 1))
                .build();

        return Student.studentBuilder()
                .person(person)
                .identifier("HUB210654")
                .build();
    }

    @Override
    void testRead() {
        Student student = loadFresh();


    }

    @Override
    void testUpdate() {

    }

    @Override
    void testDelete() {

    }
}
