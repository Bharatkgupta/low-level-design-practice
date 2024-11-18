package models;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private String id;
    private String name;
    private String email;
    private List<String> vehicles;
    private List<String> ridesOffered;
    private List<String> ridesBooked;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.vehicles = new CopyOnWriteArrayList<String>();
    }

    public String getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void addVehicle(String vehicleId) {
        vehicles.add(vehicleId);
    }

    public void removeVehicle(String vehicleId) {
        if(vehicles.contains(vehicleId)) {
            vehicles.remove(vehicles.indexOf(vehicleId));
        }
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public String toString() {
        return String.format("User %s with userId: %s", name, id);
    }

    public void addRideOffered(String rideId) {
        ridesOffered.add(rideId);
    }

    public void addRideBooked(String rideId) {
        ridesBooked.add(rideId);
    }

    public List<String> getRidesOffered() {
        return ridesOffered;
    }

    public List<String> getRidesBooked() {
        return ridesBooked;
    }
}
