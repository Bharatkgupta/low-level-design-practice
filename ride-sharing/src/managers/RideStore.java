package managers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import models.Ride;

public class RideStore {
    private static RideStore store;
    private Integer counter;
    private Map<String, Ride> availableRides;
    private Map<String, Ride> completedRides;

    private RideStore() {
        counter = 0;
        availableRides = new ConcurrentHashMap<>();
        completedRides = new ConcurrentHashMap<>();
    }

    public static RideStore getStore() {
        if(store == null) {
            synchronized(RideStore.class) {
                if(store == null) {
                    store = new RideStore();
                }
            }
        }
        return store;
    }

    public String createRide(
        String driveId, 
        String vehicleId, 
        String source, 
        String destination,
        LocalDateTime startTime,
        Duration expectedDuration,
        Integer availableSeats
    ) {
        Ride newRide = new Ride(
            Integer.toString(counter++), 
            driveId, 
            vehicleId, 
            source, 
            destination, 
            startTime, 
            expectedDuration,
            availableSeats
        );
        availableRides.put(newRide.getID(), newRide);
        return newRide.getID();
    }

    public Ride getRide(String rideId) {
        Ride temp = availableRides.getOrDefault(rideId, null);
        if(temp == null) {
            temp = completedRides.get(rideId);
        }
        return temp;
    }

    public void finishRide(String rideId) {
        Ride completedRide = availableRides.get(rideId);
        availableRides.remove(rideId);

        completedRides.put(rideId, completedRide);
    }

    public List<String> getAvailableRides() {
        return availableRides.keySet().stream().toList();
    }
}
