package ft_ormapping.repositories;

import ft_ormapping.dto.InformationEventSummaryDTO;
import ft_ormapping.model.InformationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationEventRepository extends JpaRepository<InformationEvent, Long> {

    @Query("SELECT InformationEventSummaryDTO(i) FROM InformationEvent i")
    List<InformationEventSummaryDTO> getAllInformationEventsSummary();

}
