package services.ParkingStrategies;

import models.ParkingLot;
import models.Vehicle;

public interface ParkingStrategy {
    public String park(ParkingLot parkingLot, Vehicle vehicle);
}