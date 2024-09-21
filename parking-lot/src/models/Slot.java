package models;

import enums.VehicleType;

public class Slot {
    private VehicleType supportedType;
    private Vehicle vehicle;

    public Slot(VehicleType type) {
        this.supportedType = type;
        this.vehicle = null;
    }

    public VehicleType getSlotType() {
        return supportedType;
    }

    public boolean isParked() {
        return vehicle != null;
    }

    public void parkVehicle(Vehicle vehicle) {    
        this.vehicle = vehicle;
    }

    public boolean removeVehicle() {
        if (this.vehicle != null) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
