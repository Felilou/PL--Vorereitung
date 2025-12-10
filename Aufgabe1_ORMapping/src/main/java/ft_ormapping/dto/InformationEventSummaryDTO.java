package ft_ormapping.dto;

import ft_ormapping.model.InformationEvent;
import ft_ormapping.model.InformationEventType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record InformationEventSummaryDTO(

        InformationEventType type,

        String name,

        String roomNumber
) {
    public InformationEventSummaryDTO(@Valid InformationEvent informationEvent) {
        this(informationEvent.getType(),
                informationEvent.getName(),
                String.format("%s%s",
                        informationEvent.getRoom().getBuilding(),
                        informationEvent.getRoom().getLevel()));
    }
}
