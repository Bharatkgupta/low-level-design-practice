package models;

public class Player {
    private String id;
    private String name;

    public Player(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    public String toString() {
        return String.format("Player: %s with id: %s", this.name, this.id);
    }
}
