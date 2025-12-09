package ft_ormapping.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {

    @NotNull
    String building;

    @NotNull
    String level;

    @NotNull
    String roomNo;

    String description;

    @PositiveOrZero
    int numberOfSeats;

    @PositiveOrZero
    int numberOfDesks;

    protected Room(String building, String level, String roomNo, String description, int numberOfSeats, int numberOfDesks) {
        this.building = building;
        this.level = level;
        this.roomNo = roomNo;
        this.description = description;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDesks = numberOfDesks;
    }
}
