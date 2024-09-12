package models;

import java.util.List;
import java.util.UUID;

import services.PlayerManager;

import java.util.Collections;

public class Game {
    private String id;
    private Board board;
    private int numOfDices;
    private List<String> players;
    private List<Integer> locations;
    private int currentPlayerIdx;
    private String winner;

    public Game(Board board, int numOfDices, List<String> players) {
        this.id = UUID.randomUUID().toString();
        this.board = board;
        this.numOfDices = numOfDices;
        this.players = players;
        Collections.fill(locations, Integer.valueOf(0));
        this.currentPlayerIdx = 0;
        this.winner = null;
    }

    public void addPlayer(String playerID) {
        players.add(playerID);
    }
    public void startGame() {
        PlayerManager manager = PlayerManager.getManager();
        Dice dice = Dice.getDice();
        do {
            currentPlayerIdx = currentPlayerIdx%players.size();
            String currentPlayerID = players.get(currentPlayerIdx);
            Player currentPlayer = manager.getPlayer(currentPlayerID);
            int currentPlayerLocation = locations.get(currentPlayerIdx);

            int steps = 0;
            for (int d = 0; d < numOfDices; d++) {
                steps += dice.roll();
            }
            if(board.isOutOfBound(currentPlayerLocation+steps)) {
                continue;
            }
            currentPlayerLocation = board.getFinalLocation(currentPlayerLocation+steps);
            locations.set(currentPlayerIdx, currentPlayerLocation);
        } while (!board.isWinner(locations.get(currentPlayerIdx++)));
        this.winner = players.get(currentPlayerIdx-1);
    }
    public String getWinner() {
        return this.winner;
    }
}
