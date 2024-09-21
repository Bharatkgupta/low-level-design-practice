package models;

import java.util.List;

import enums.VehicleType;

public class Floor {
    private List<Slot> slots;
    private int numFreeSlots;
    private int numOccupiedSlots;

    public Floor(List<Slot> slots) {
        this.slots = slots;
        numFreeSlots = slots.size();
        numOccupiedSlots = 0;
    }

    public List<Slot> getSlots() {
        return this.slots;
    }

    public boolean removeVehicle(int slotNo) {
        if (slotNo > 0 && slotNo <= slots.size()) {
            return this.slots.get(slotNo - 1).removeVehicle();
        }
        return false;
    }

    public int getNumberOfSlots() {
        return numFreeSlots + numOccupiedSlots;
    }

    public int getNumberOfFreeSlots() {
        return numFreeSlots;
    }

    public int getNumberOfOccupiedSlots() {
        return numOccupiedSlots;
    }

    public Slot getSlot(int index) {
        return slots.get(index);
    }

    public int freeCount(VehicleType type) {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.getSlotType() == type && !slot.isParked()) {
                count++;
            }
        }
        return count;
    }
}
