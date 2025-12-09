package ft_ormapping.repositories;

import ft_ormapping.model.EventTimeSlot;
import ft_ormapping.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTimeSlotRepository extends JpaRepository<EventTimeSlot, Long> {
}
