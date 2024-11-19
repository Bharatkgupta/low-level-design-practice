package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Ride {
    private String id;
    private String driverId;
    private List<String> riders;
    private String vehicleId;
    private String source;
    private String destination;
    private LocalDateTime startTime;
    private Duration expectedDuration;
    private Integer availableSeats;

    public Ride(
        String id,
        String driveId, 
        String vehicleId, 
        String source, 
        String destination,
        LocalDateTime startTime,
        Duration expectedDuration,
        Integer availableSeats
    ) {
        this.id = id;
        this.driverId = driveId;
        this.vehicleId = vehicleId;
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.expectedDuration = expectedDuration;
        this.availableSeats = availableSeats;
    }

    public String getID() {
        return id;
    }

    public String getDriverID() {
        return driverId;
    }

    public String getVehicleID() {
        return vehicleId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Duration getExpectedDuration() {
        return expectedDuration;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer newAvailableSeats) {
        this.availableSeats = newAvailableSeats;
    }

    public void addRider(String userId) {
        riders.add(userId);
    }

    public String toString() {
        return String.format("This is a ride from %s to %s, which will start at %t and expected duration is %t. Available Seats: %d", source, destination, startTime, expectedDuration, availableSeats);
    }
}

