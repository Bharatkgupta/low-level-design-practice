package services.RideMatching;

import java.util.List;

public interface RideMatcher {
    String matchRide(String source, String destination, Integer seatsRequired, List<String> availableRides);
}
