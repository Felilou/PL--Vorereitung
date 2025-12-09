package ft_ormapping.model;

import lombok.Builder;

public class MakerSpaceRoom extends Room{

    String specialEquipment;

    @Builder
    protected MakerSpaceRoom(String building, String level, String roomNo, String description, int numberOfSeats, int numberOfDesks, String specialEquipment) {
        super(building, level, roomNo, description, numberOfSeats, numberOfDesks);
        this.specialEquipment = specialEquipment;
    }
}
