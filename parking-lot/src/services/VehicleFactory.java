package services;

import enums.Color;
import models.Bike;
import models.Car;
import models.Truck;
import models.Vehicle;

public class VehicleFactory {
    private static VehicleFactory factory = new VehicleFactory();
    private VehicleFactory() {};

    public static synchronized VehicleFactory getVehicleFactory() {
        if (factory == null) {
            factory = new VehicleFactory();
        }
        return factory;
    }

    public Vehicle createVehicle(String registrationNumber, String vehicleType, Color color) {
        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(registrationNumber, color);
                break;
            case "Truck":
                vehicle = new Truck(registrationNumber, color);
                break;
            case "Bike":
                vehicle = new Bike(registrationNumber, color);
                break;
            default:
                System.out.println(String.format("%s is not supported. Park somewhere else.", vehicleType));
                break;
        }
        return vehicle;
    }

}
