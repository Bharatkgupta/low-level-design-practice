package services;

import enums.Color;
import enums.VehicleType;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import services.FloorLayoutStrategies.EqualRatio;
import services.FloorLayoutStrategies.FloorLayoutStrategy;
import services.FloorLayoutStrategies.RandomRatio;
import services.ParkingStrategies.BestParkingSlot;
import services.ParkingStrategies.NearestParkingSlot;
import services.ParkingStrategies.ParkingStrategy;

public class ParkingService {
    private static ParkingService parkingService;

    private ParkingService() {
    };

    public static synchronized ParkingService getParkingService() {
        if (parkingService == null) {
            parkingService = new ParkingService();
        }
        return parkingService;
    }

    public void createParkingLot() {
        // for now we just create a parking lot with random number of floors and random
        // number of slots per floor
        // Later we can create a command line interface or UI interface to allow user to
        // create a parking lot
        String parkingLotId = "PA-123";
        ParkingRepository repository = ParkingRepository.getParkingRepository();
        ParkingLot parkingLot = repository.createParkingLot(parkingLotId, 400701);

        for (int i = 0; i < (int) (Math.random() * 5); i++) {
            FloorLayoutStrategy strategy = (Math.random() * 2) > 1 ? new EqualRatio() : new RandomRatio();
            parkingLot.addFloor((int) (Math.random() * 10), strategy);
        }
    }

    public void parkVehicle() {
        String parkingLotId = "PA-123";

        VehicleFactory factory = VehicleFactory.getVehicleFactory();
        Vehicle vehicle = null;
        int temp = (int) (Math.random() * 3);
        if (temp < 1) {
            vehicle = factory.createVehicle("KA-01-HH-1234", "Car", Color.BLUE);
        } else if (temp < 2) {
            vehicle = factory.createVehicle("KA-01-HH-1234", "Truck", Color.RED);
        } else {
            vehicle = factory.createVehicle("KA-01-HH-1234", "Bike", Color.GREEN);
        }

        ParkingStrategy strategy = (Math.random() * 2) > 1 ? new NearestParkingSlot() : new BestParkingSlot();

        ParkingRepository repository = ParkingRepository.getParkingRepository();
        ParkingLot parkingLot = repository.getParkingLot(parkingLotId);

        String ticketId = strategy.park(parkingLot, vehicle); // parkingLotId + floor no. + slot no. + vehicle registration
                                                           // number

        if (ticketId != null) {
            TicketService service = TicketService.getTicketService();
            service.issueTicket(ticketId);
        }
    }

    public void unparkVehicle() {
        String ticketId = "PA-123_1_1_KA-01-HH-1234";
        TicketService service = TicketService.getTicketService();
        Ticket ticket = service.getTicket(ticketId);

        if (ticket == null) {
            return;
        } else if (ticket.isPaid()) {
            return;
        }

        ParkingRepository repository = ParkingRepository.getParkingRepository();
        ParkingLot parkingLot = repository.getParkingLot(ticket.getParkingLotId());

        boolean isUnparked = parkingLot.removeVehicle(ticket.getFloorNo(), ticket.getSlotNo());

        if (!isUnparked) {
            return;
        }

        int duration = ticket.setPaid();

        PaymentGatway gatway = PaymentGatway.getPaymentGatway();
        int chargets = gatway.calculateCharges(duration);

        System.out.println(chargets);
    }

    public void freeCount() {
        String parkingLotId = "PA-123";
        VehicleType type = VehicleType.values()[(int) (Math.random() * VehicleType.values().length)];

        ParkingRepository repository = ParkingRepository.getParkingRepository();
        ParkingLot parkingLot = repository.getParkingLot(parkingLotId);

        int count = parkingLot.freeCount(type);

        System.out.println(count);
    }

    public void display() {
        String parkingLotId = "PA-123";
        ParkingRepository repository = ParkingRepository.getParkingRepository();
        ParkingLot parkingLot = repository.getParkingLot(parkingLotId);
        System.out.println(parkingLot);
    }
}
