package services;

import java.util.List;
import java.util.ArrayList;

import models.Board;
import models.Game;

public class GameService {
    private static GameService service;
    private List<Game> gameHistory;

    private GameService() {
    };

    public static synchronized GameService getGameService() {
        if (service == null) {
            service = new GameService();
            service.gameHistory = new ArrayList<>();
        }
        return service;
    }

    public Game createGame() {
        CLI cli = CLI.getCli();
        PlayerManager manager = PlayerManager.getManager();

        cli.display(
                "Before staring the game, let's make our board, decide number of dices and select players who will play the game...");
        cli.display("");

        int boardSize;
        while (true) {
            String input = cli.takeInput("Enter board size: ");
            cli.display("");

            try {
                boardSize = Integer.parseInt(input);
                if (boardSize <= 0 || boardSize > 1000) {
                    cli.display("Invalid input. Please enter a number between 1 and 1000.");
                    cli.display("");
                    continue;
                }
                break;
            } catch (Exception e) {
                cli.display("Invalid input. Please enter a number.");
                cli.display("");
            }
        }
        Board board = new Board(boardSize);

        cli.display("Let's add snakes to the board...");
        cli.display("");
        while (true) {
            String start = cli.takeInput("Enter start of snake: ");
            String end = cli.takeInput("Enter end of snake: ");
            cli.display("");

            try {
                if (!board.insertSnake(Integer.parseInt(start), Integer.parseInt(end))) {
                    cli.display("Invalid input. Please enter valid start and end of snake.");
                    cli.display("");
                    continue;
                } else {
                    String command = cli.takeInput("press S to add more snakes or press enter to continue...");
                    if (command.equalsIgnoreCase("s")) {
                        continue;
                    }
                    break;
                }
            } catch (Exception e) {
                cli.display("Invalid input. Please enter valid start and end of snake.");
                cli.display("");
            }
        }

        cli.display("Let's add ladders to the board...");
        cli.display("");
        while (true) {
            String start = cli.takeInput("Enter start of ladder: ");
            String end = cli.takeInput("Enter end of ladder: ");
            cli.display("");

            try {
                if (!board.insertLadder(Integer.parseInt(start), Integer.parseInt(end))) {
                    cli.display("Invalid input. Please enter valid start and end of ladder.");
                    cli.display("");
                    continue;
                } else {
                    String command = cli.takeInput("press L to add more ladders or press enter to continue...");
                    if (command.equalsIgnoreCase("l")) {
                        continue;
                    }
                    break;
                }
            } catch (Exception e) {
                cli.display("Invalid input. Please enter valid start and end of ladder.");
                cli.display("");
            }
        }

        cli.display("Now let's decide number of dices...");
        cli.display("");
        int numOfDices;
        while (true) {
            String input = cli.takeInput("Enter number of dices: ");
            cli.display("");

            try {
                numOfDices = Integer.parseInt(input);
                if (numOfDices <= 0 || numOfDices > 5) {
                    cli.display("Invalid input. Please enter a number between 1 and 5.");
                    cli.display("");
                    continue;
                }
                break;
            } catch (Exception e) {
                cli.display("Invalid input. Please enter a number.");
                cli.display("");
            }
        }

        Game game = new Game(board, numOfDices);

        cli.display("Let's select players who will play the game...");
        cli.display("");
        while (true) {
            String playerToAdd = cli.takeInput("Enter ID of player who wants to play: ");
            cli.display("");

            if (manager.getPlayer(playerToAdd) == null) {
                cli.display("Invalid input. Please enter a valid ID.");
                cli.display("");
                continue;
            } else {
                if(!game.addPlayer(playerToAdd)) {
                    cli.display("Player already added. Please enter a different ID.");
                    cli.display("");
                    continue;
                }
                String command = cli.takeInput("press P to add more players or press enter to continue...");
                if (command.equalsIgnoreCase("p")) {
                    continue;
                } else {
                    break;
                }
            }
        }

        gameHistory.add(game);
        return game;
    }

    public Game getGame(String id) {
        for (Game game : gameHistory) {
            if (game.getId().equals(id)) {
                return game;
            }
        }
        return null;
    }
}
