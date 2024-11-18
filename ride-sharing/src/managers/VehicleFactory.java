package managers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import models.Vehicle;

public class VehicleFactory {
    private static VehicleFactory factory;
    private Map<String, Vehicle> vehicles;
    private Integer counter;

    private VehicleFactory() {
        vehicles = new ConcurrentHashMap<String, Vehicle>();
        counter = 0;
    }

    public static VehicleFactory getFactory() {
        if(factory == null) {
            synchronized(VehicleFactory.class) {
                if(factory == null) {
                    factory = new VehicleFactory();
                }
            }
        }
        return factory;
    }

    public String createVehicle(String name, String regNo, Integer numSeats) {
        Vehicle newVehicle = new Vehicle(Integer.toString(counter++), name, regNo, numSeats);
        vehicles.put(newVehicle.getID(), newVehicle);
        return newVehicle.getID();
    }

    public Vehicle getVehicle(String vehicleId) {
        return vehicles.get(vehicleId);
    }
}
