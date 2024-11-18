package services.RideMatching;

import java.util.List;

public class EARLIESTSTARTTIME implements RideMatcher {
    public String matchRide(String source, String destination, Integer seatsRequired, List<String> availableRides) {
        return availableRides.get(0);
    }
}