package services.FloorLayoutStrategies;

import enums.VehicleType;
import models.Floor;
import models.Slot;

import java.util.ArrayList;
import java.util.List;

public class RandomRatio implements FloorLayoutStrategy {
    public Floor createFloor(int numSlots) {
        List<Slot> slots = new ArrayList<Slot>(numSlots);
        while (slots.size() < numSlots) {
            slots.add(new Slot(VehicleType.values()[(int) (Math.random() * VehicleType.values().length)]));
        }
        return new Floor(slots);
    }
}
