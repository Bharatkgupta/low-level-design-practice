package models;

import java.util.UUID;

public class Player {
    private String id;
    private String name;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }
    public String getID() {
        return this.id;
    }
}
