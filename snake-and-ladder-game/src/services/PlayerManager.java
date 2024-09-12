package services;

import java.util.List;

import models.Player;

public class PlayerManager {
    private static PlayerManager manager;
    private List<Player> players;
    private PlayerManager() {};

    public static synchronized PlayerManager getManager() {
        if(manager == null) {
            manager = new PlayerManager();
        }
        return manager;
    }

    public String createPlayer(String name) {
        Player player = new Player(name);
        this.players.add(player);
        return player.getID();
    }

    public Player getPlayer(String id) {
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getID() == id) {
                return players.get(i);
            }
        }
        return null;
    }
}
