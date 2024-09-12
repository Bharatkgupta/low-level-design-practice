package services;

import java.util.List;

import models.Game;

public class GameService {
    private static GameService service;
    private GameService() {};
    private List<Game> gameHistory;

    public static synchronized GameService getGameService() {
        if(service == null) {
            service = new GameService();
        }
        return service;
    }
    public Game creatGame() {
        CLI cli = CLI.getCli();

        return null;
    }
}
