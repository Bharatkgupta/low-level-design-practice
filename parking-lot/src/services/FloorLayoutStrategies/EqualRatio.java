package services.FloorLayoutStrategies;

import enums.VehicleType;
import models.Floor;
import models.Slot;

import java.util.ArrayList;
import java.util.List;

public class EqualRatio implements FloorLayoutStrategy {
    public Floor createFloor(int numSlots) {
        int numSlotsForAType = numSlots/VehicleType.values().length;
        List<Slot> slots = new ArrayList<>();
        for (VehicleType type : VehicleType.values()) {
            for (int i = 0; i < numSlotsForAType; i++) {
                slots.add(new Slot(type));
            }
        }
        while (slots.size() < numSlots) {
            slots.add(new Slot(VehicleType.values()[(int) (Math.random() * VehicleType.values().length)]));
        }
        return new Floor(slots);
    }
}
