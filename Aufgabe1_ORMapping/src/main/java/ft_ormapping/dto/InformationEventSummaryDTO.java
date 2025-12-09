package ft_ormapping.dto;

import ft_ormapping.model.InformationEvent;
import ft_ormapping.model.InformationEventType;
import jakarta.validation.constraints.NotNull;

public record InformationEventSummaryDTO(

        @NotNull
        InformationEventType type,

        @NotNull
        String name,

        @NotNull
        String roomNumber
) {
    public InformationEventSummaryDTO(@NotNull InformationEvent informationEvent) {
        this(informationEvent.getType(),
                informationEvent.getName(),
                String.format("%s%s",
                        informationEvent.getRoom().getBuilding(),
                        informationEvent.getRoom().getLevel()));
    }

}
