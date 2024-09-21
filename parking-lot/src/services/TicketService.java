package services;

import models.Ticket;
import java.util.HashMap;

public class TicketService {
    private static TicketService service;
    private HashMap<String, Ticket> tickets;

    private TicketService() {
        tickets = new HashMap<>();
    }

    public static synchronized TicketService getTicketService() {
        if (service == null) {
            service = new TicketService();
        }
        return service;
    }

    public Ticket issueTicket(String ticketId) {
        String[] parts = ticketId.split("_");
        String parkingLotId = parts[0];
        int floorNo = Integer.valueOf(parts[1]);
        int slotNo = Integer.valueOf(parts[2]);
        String vehicleRegistrationNumber = parts[3];
        Ticket ticket = new Ticket(parkingLotId, floorNo, slotNo, vehicleRegistrationNumber);
        tickets.put(ticketId, ticket);
        return ticket;
    }

    public Ticket getTicket(String ticketId) {
        if (!tickets.containsKey(ticketId)) {
            return null;
        }
        return tickets.get(ticketId);
    }
}
