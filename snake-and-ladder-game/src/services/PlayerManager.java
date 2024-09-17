package services;

import java.util.List;
import java.util.ArrayList;

import models.Player;

public class PlayerManager {
    private static PlayerManager manager;
    private int counter;
    private List<Player> players;
    private PlayerManager() {
        this.counter = 0;
    };

    public static synchronized PlayerManager getManager() {
        if(manager == null) {
            manager = new PlayerManager();
            manager.players = new ArrayList<>();
        }
        return manager;
    }

    public String createPlayer(String name) {
        Player player = new Player(name, Integer.toString(counter++));
        this.players.add(player);
        return player.getID();
    }

    public Player getPlayer(String id) {
        if(Integer.parseInt(id) < players.size()) {
            return players.get(Integer.parseInt(id));
        }
        return null;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
