package ft_ormapping.model;

import lombok.Builder;

public class PresentationRoom extends Room {

    @Builder
    protected PresentationRoom(String building, String level, String roomNo, String description, int numberOfSeats, int numberOfDesks) {
        super(building, level, roomNo, description, numberOfSeats, numberOfDesks);
    }
}
