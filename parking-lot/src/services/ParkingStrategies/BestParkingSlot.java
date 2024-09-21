package services.ParkingStrategies;

import java.util.List;
import models.ParkingLot;
import models.Vehicle;
import models.Floor;
import models.Slot;

public class BestParkingSlot implements ParkingStrategy {
    public String park(ParkingLot parkingLot, Vehicle vehicle) {
        List<Floor> floors = parkingLot.getFloors();

        for (int i = 0; i < floors.size(); i++) {
            List<Slot> slots = floors.get(i).getSlots();

            for (int j = 0; j < slots.size(); j++) {
                if (slots.get(j).isParked() && vehicle.isParkable(slots.get(j).getSlotType())) {
                    slots.get(j).parkVehicle(vehicle);
                    return String.format(
                            "%s_%s_%s_%s",
                            parkingLot.getId(),
                            Integer.valueOf(i + 1).toString(),
                            Integer.valueOf(j + 1).toString(),
                            vehicle.getRegistrationNumber());
                }
            }
        }
        return null;
    }
}
