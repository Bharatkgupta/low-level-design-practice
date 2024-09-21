package models;

import enums.Color;
import enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String rn, Color color) {
        super(rn, color);
    }

    @Override
    public boolean isParkable(VehicleType type) {
        return type == VehicleType.BIKE;
    }
}
