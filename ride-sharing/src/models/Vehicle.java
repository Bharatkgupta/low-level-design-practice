package models;

public class Vehicle {
    private String id;
    private String name;
    private String regNo;
    private Integer numberOfSeats;

    public Vehicle(String id, String name, String regNo, Integer numSeats) {
        this.id = id;
        this.name = name;
        this.regNo = regNo;
        this.numberOfSeats = numSeats;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getRegNo() {
        return this.regNo;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public String toString() {
        return String.format("%s vehicle with ID: %s", name, id);
    }
}
