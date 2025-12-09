package ft_ormapping.repositories;

import ft_ormapping.model.Person;
import ft_ormapping.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

}
