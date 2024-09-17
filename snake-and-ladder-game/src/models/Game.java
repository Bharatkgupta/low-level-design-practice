package models;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import services.CLI;
import services.PlayerManager;

public class Game {
    private String id;
    private Board board;
    private int numOfDices;
    private List<String> players;
    private List<Integer> locations;
    private int currentPlayerIdx;
    private String winner;

    public Game(Board board, int numOfDices) {
        this.id = UUID.randomUUID().toString();
        this.board = board;
        this.numOfDices = numOfDices;
        this.players = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.currentPlayerIdx = 0;
        this.winner = null;
    }

    public boolean addPlayer(String playerID) {
        if (players.contains(playerID)) {
            return false;
        }
        players.add(playerID);
        locations.add(0);
        return true;
    }

    public void startGame() {
        CLI cli = CLI.getCli();
        PlayerManager manager = PlayerManager.getManager();
        Dice dice = Dice.getDice();

        cli.display("Game Started!!");
        cli.display("");
        do {
            currentPlayerIdx = currentPlayerIdx % players.size();
            String currentPlayerID = players.get(currentPlayerIdx);
            Player currentPlayer = manager.getPlayer(currentPlayerID);
            int currentPlayerLocation = locations.get(currentPlayerIdx);

            cli.display(String.format("Current player: %s", currentPlayer));
            cli.display(String.format("Current player location: %s", currentPlayerLocation));
            cli.display("Let's roll the dice!!");
            cli.display("");

            int steps = 0;
            for (int d = 0; d < numOfDices; d++) {
                cli.takeInput("press enter to roll the dice...");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(500); // sleep for 5 milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cli.display(".");
                }
                int value = dice.roll();
                cli.display(String.format("Dice value: %s. Number of rolls remaining: %s", value, numOfDices - d - 1));
                cli.display("");
                steps += value;
            }
            cli.display("Number of steps: " + steps);
            cli.display("");
            if (board.isOutOfBound(currentPlayerLocation + steps)) {
                cli.display("Sorry, you can't move further. You are out of the board.");
                cli.display("");
                continue;
            }
            cli.display(String.format("Current player moving to %s", currentPlayerLocation + steps));
            cli.display("");
            currentPlayerLocation = board.getFinalLocation(currentPlayerLocation + steps);
            cli.display(String.format("Final location of %s is %s", currentPlayer.getName(), currentPlayerLocation));
            cli.display("");
            locations.set(currentPlayerIdx, currentPlayerLocation);
        } while (!board.isWinner(locations.get(currentPlayerIdx++)));
        this.winner = players.get(currentPlayerIdx - 1);
        cli.display("Game Finished!!");
        cli.display("");
    }

    public String getWinner() {
        return this.winner;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return String.format("Game ID: %s. Winner: %s", this.id, this.winner);
    }
}
