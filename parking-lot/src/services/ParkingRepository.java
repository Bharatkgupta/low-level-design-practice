package services;

import java.util.HashMap;
import models.ParkingLot;

public class ParkingRepository {
    private static ParkingRepository service;
    private HashMap<String, ParkingLot> parkingLots;

    private ParkingRepository() {
        parkingLots = new HashMap<>();
    }

    public static synchronized ParkingRepository getParkingRepository() {
        if (service == null) {
            service = new ParkingRepository();
        }
        return service;
    }

    public ParkingLot createParkingLot(String id, int pincode) {
        ParkingLot parkingLot = new ParkingLot(id, pincode);
        parkingLots.put(id, parkingLot);
        return parkingLot;
    }

    public ParkingLot getParkingLot(String id) {
        return parkingLots.get(id);
    }
}
