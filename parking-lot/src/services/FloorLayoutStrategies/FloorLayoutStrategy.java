package services.FloorLayoutStrategies;

import models.Floor;

public interface FloorLayoutStrategy {
    public Floor createFloor(int numSlots);
}
