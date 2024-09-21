package models;

import java.util.List;

import enums.VehicleType;

import java.util.ArrayList;

import services.FloorLayoutStrategies.FloorLayoutStrategy;

public class ParkingLot {
    private String id;
    private int pincode;
    private List<Floor> floors;

    public ParkingLot(String id, int pincode) {
        this.id = id;
        this.pincode = pincode;
        this.floors = new ArrayList<>();
    }

    public int addFloor(int numSlots, FloorLayoutStrategy strategy) {
        Floor floor = strategy.createFloor(numSlots);
        this.floors.add(floor);
        return this.floors.size() - 1;
    }

    public String getId() {
        return this.id;
    }

    public List<Floor> getFloors() {
        return this.floors;
    }

    public boolean removeVehicle(int floorNo, int slotNo) {
        if (floorNo <= this.floors.size()) {
            return this.floors.get(floorNo - 1).removeVehicle(slotNo);
        }
        return false;
    }

    public int freeCount(VehicleType type) {
        int count = 0;
        for (Floor floor : this.floors) {
            count += floor.freeCount(type);
        }
        return count;
    }

    public String toString() {
        return String.format("ParkingLot: %s on pincode: %s", this.id, this.pincode);
    }
}
