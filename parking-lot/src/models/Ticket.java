package models;

import java.time.Instant;
import java.time.Duration;

public class Ticket {
    private String parkingLotId;
    private int floorNo;
    private int slotNo;
    private String vehicleRegistrationNumber;
    private Instant creationTimeStamp;
    private Instant paymentTimeStamp;

    public Ticket(String parkingLotId, int floorNo, int slotNo, String vehicleRegistrationNumber) {
        this.parkingLotId = parkingLotId;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.creationTimeStamp = Instant.now();
        this.paymentTimeStamp = null;
    }

    public String toString() {
        return String.format(
                "Ticket: %s_%s_%s_%s",
                parkingLotId,
                Integer.valueOf(floorNo).toString(),
                Integer.valueOf(slotNo).toString(),
                vehicleRegistrationNumber
        );
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getFloorNo() {   
        return floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public boolean isPaid() {
        return paymentTimeStamp != null;
    }

    public int setPaid() {
        this.paymentTimeStamp = Instant.now();
        return (int) Duration.between(paymentTimeStamp, creationTimeStamp).toHours();
    }
}
