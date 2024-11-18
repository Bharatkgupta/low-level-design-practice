package services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import enums.SelectionType;
import managers.RideStore;
import managers.UserManager;
import managers.VehicleFactory;
import models.Ride;
import models.User;
import models.Vehicle;
import services.RideMatching.EARLIESTENDTIME;
import services.RideMatching.EARLIESTSTARTTIME;
import services.RideMatching.LOWESTDURATION;
import services.RideMatching.RideMatcher;

public class RideSharingService {
    private static RideSharingService service;
    private RideStore store;
    private UserManager manager;
    private VehicleFactory factory;

    private RideSharingService() {
        store = RideStore.getStore();
        manager = UserManager.getManager();
        factory = VehicleFactory.getFactory();
    }

    public static RideSharingService getService() {
        if (service == null) {
            synchronized (RideSharingService.class) {
                if (service == null) {
                    service = new RideSharingService();
                }
            }
        }
        return service;
    }

    public String offerRide(
            String driverId,
            String vehicleId,
            String source,
            String destination,
            LocalDateTime startTime) {
        // check if driver has provided vehicle
        User driver = manager.getUser(driverId);
        if (driver.getVehicles().contains(vehicleId) == false) {
            return null;
        }

        // get vehicle
        Vehicle vehicle = factory.getVehicle(vehicleId);

        // find duration using a trip planner service for now I am hardcoding it
        Duration duration = Duration.ofHours(10);

        String rideId = store.createRide(
                driverId,
                vehicleId,
                source,
                destination,
                startTime,
                duration,
                vehicle.getNumberOfSeats() - 1
            );

        driver.addRideOffered(rideId);

        return rideId;
    }

    public String bookRide(
            String source,
            String destination,
            List<String> riders,
            SelectionType type) {
        List<String> rides = store.getAvailableRides();
        RideMatcher matcher;

        switch (type) {
            case LOWESTDURATION:
                matcher = new LOWESTDURATION();
                break;
            case EARLIESTENDTIME:
                matcher = new EARLIESTENDTIME();
                break;
            case EARLIESTSTARTTIME:
                matcher = new EARLIESTSTARTTIME();
                break;
            default:
                // default to lowest duration
                matcher = new LOWESTDURATION();
                break;
        }

        String rideId = matcher.matchRide(source, destination, riders.size(), rides);

        if (rideId != null) {
            Ride ride = store.getRide(rideId);

            for (String riderId : riders) {
                ride.addRider(riderId);

                User rider = manager.getUser(riderId);
                rider.addRideBooked(rideId);
            }

            ride.setAvailableSeats(ride.getAvailableSeats() - riders.size());
        }

        return rideId;
    }
}
