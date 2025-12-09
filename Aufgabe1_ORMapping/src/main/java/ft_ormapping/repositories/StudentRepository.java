package ft_ormapping.repositories;

import ft_ormapping.model.Student;
import ft_ormapping.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
