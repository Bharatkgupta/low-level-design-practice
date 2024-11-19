import java.time.LocalDateTime;
import java.util.List;

import enums.SelectionType;
import managers.PaymentGateway;
import managers.RideStore;
import managers.UserManager;
import managers.VehicleFactory;
import services.RideSharingService;

public class App {
    public static void main(String[] args) throws Exception {
        RideSharingDemo();
    }

    static void RideSharingDemo() {
        RideStore store = RideStore.getStore();
        UserManager manager = UserManager.getManager();
        VehicleFactory factory = VehicleFactory.getFactory();
        PaymentGateway gateway = PaymentGateway.getGateway();
        RideSharingService service = RideSharingService.getService();

        // add a users
        String userId1 = manager.createUser("John Doe", "jdoe@me.com"); // driver
        String userId2 = manager.createUser("Jane Doe", "jane@me.com"); // rider
        String userId3 = manager.createUser("Bob Doe", "bob@me.com"); // rider
        String userId4 = manager.createUser("Alice Doe", "alice@me.com"); // rider
        System.out.println("User Ids: " + userId1 + ", " + userId2 + ", " + userId3 + ", " + userId4);

        // add vehicles
        String vehicleId1 = factory.createVehicle("Honda Civic", "ABC123", 4);
        System.out.println(factory.getVehicle(vehicleId1));

        // register vehicles
        manager.registerVehicle(userId1, vehicleId1);
        System.out.println(manager.getUser(userId1));

        // offer a ride
        String rideId = service.offerRide(userId1, vehicleId1, "Mumbai", "Delhi", LocalDateTime.now().plusDays(1));
        System.out.println(store.getRide(rideId));

        // book a ride
        String bookedRideId = service.bookRide("Mumbai", "Delhi", List.of(userId2, userId3, userId4),
                SelectionType.EARLIESTSTARTTIME);
        System.out.println(store.getRide(bookedRideId));

        // start a ride
        // ride going on ........

        // finish a ride
        store.finishRide(bookedRideId);

        // do payment for each rider
        gateway.getBreakup(store.getRide(bookedRideId));

        // get rides offered by a user
        List<String> ridesOffered = manager.getUser(userId1).getRidesOffered();
        System.out.println(ridesOffered);

        // get rides taken by a user
        List<String> ridesBooked = manager.getUser(userId2).getRidesBooked();
        System.out.println(ridesBooked);
    }
}

/*
 *
 * Requiremnts
 * 
 * APIs to Expose
 * 
 * - addUser(name, email)
 * - addVehicle(name, regno)
 * - offerRide(driver, vehicleId, availableSeats, source, destination,
 * - startTime, estimatedDuration, distance)
 * - bookRides(source, destination, seatsRequired, strategyForSelection)
 * - startRide(rideId)
 * - completeRide(rideId) -- notify each rider their amount to be paid;
 * - getRidesOffered(userId)
 * - getRidesTaken(userId)
 * 
 * Entities
 * 
 * - Ride
 * - User
 * - Vehicle
 * 
 * Managers
 * 
 * - PaymentGateway
 * - RideStore
 * - UserManager
 * - VehicleFactory
 * 
 * Services
 * 
 * - RideSharingService
 * 
 */