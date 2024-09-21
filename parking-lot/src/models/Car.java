package models;

import enums.Color;
import enums.VehicleType;

public class Car extends Vehicle {
    public Car(String rn, Color color) {
        super(rn, color);
    }

    @Override
    public boolean isParkable(VehicleType type) {
        return type == VehicleType.CAR;
    }
}
