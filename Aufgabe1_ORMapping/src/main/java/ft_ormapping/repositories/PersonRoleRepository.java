package ft_ormapping.repositories;

import ft_ormapping.model.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, Long> { }
