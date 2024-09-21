package models;

import enums.Color;
import enums.VehicleType;

public class Truck extends Vehicle{
    public Truck(String rn, Color color) { 
        super(rn, color);
    }

    @Override
    public boolean isParkable(VehicleType type) {
        return type == VehicleType.TRUCK;
    }
}
