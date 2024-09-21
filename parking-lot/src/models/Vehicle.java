package models;

import enums.Color;
import enums.VehicleType;

public abstract class Vehicle {
    private String rn;
    private Color color;

    public Vehicle(String rn, Color color) {
        this.rn = rn;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return rn;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "Car: " + getRegistrationNumber() + " with color: " + getColor();
    }

    public abstract boolean isParkable(VehicleType type);
}
