package services;

import java.util.List;

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
        }
        return service;
    }

    public Game createGame() {
        CLI cli = CLI.getCli();
        PlayerManager manager = PlayerManager.getManager();

        cli.display(
                "Before staring the game, let's make our board, decide number of dices and select players who will play the game...");
        cli.display(null);

        int boardSize;
        while (true) {
            String input = cli.takeInput("Enter board size: ");
            cli.display(null);

            try {
                boardSize = Integer.parseInt(input);
                if (boardSize <= 0 || boardSize > 1000) {
                    cli.display("Invalid input. Please enter a number between 1 and 1000.");
                    cli.display(null);
                    continue;
                }
                break;
            } catch (Exception e) {
                cli.display("Invalid input. Please enter a number.");
                cli.display(null);
            }
        }
        Board board = new Board(boardSize);

        cli.display("Let's add snakes to the board...");
        cli.display(null);
        while (true) {
            String start = cli.takeInput("Enter start of snake: ");
            String end = cli.takeInput("Enter end of snake: ");
            cli.display(null);

            try {
                if (!board.insertSnake(Integer.parseInt(start), Integer.parseInt(end))) {
                    cli.display("Invalid input. Please enter valid start and end of snake.");
                    cli.display(null);
                    continue;
                } else {
                    String command = cli.takeInput("press S to add more snakes or press any key to continue...");
                    if (command.toLowerCase() == "s") {
                        continue;
                    }
                    break;
                }
            } catch (Exception e) {
                cli.display("Invalid input. Please enter valid start and end of snake.");
                cli.display(null);
            }
        }

        cli.display("Let's add ladders to the board...");
        cli.display(null);
        while (true) {
            String start = cli.takeInput("Enter start of ladder: ");
            String end = cli.takeInput("Enter end of ladder: ");
            cli.display(null);

            try {
                if (!board.insertLadder(Integer.parseInt(start), Integer.parseInt(end))) {
                    cli.display("Invalid input. Please enter valid start and end of ladder.");
                    cli.display(null);
                    continue;
                } else {
                    String command = cli.takeInput("press L to add more ladders or press any key to continue...");
                    if (command.toLowerCase() == "l") {
                        continue;
                    }
                    break;
                }
            } catch (Exception e) {
                cli.display("Invalid input. Please enter valid start and end of ladder.");
                cli.display(null);
            }
        }

        cli.display("Now let's decide number of dices...");
        cli.display(null);
        int numOfDices;
        while (true) {
            String input = cli.takeInput("Enter number of dices: ");
            cli.display(null);

            try {
                numOfDices = Integer.parseInt(input);
                if (numOfDices <= 0 || numOfDices > 5) {
                    cli.display("Invalid input. Please enter a number between 1 and 5.");
                    cli.display(null);
                    continue;
                }
                break;
            } catch (Exception e) {
                cli.display("Invalid input. Please enter a number.");
                cli.display(null);
            }
        }

        Game game = new Game(board, numOfDices);

        cli.display("Let's select players who will play the game...");
        cli.display(null);
        while (true) {
            String playerToAdd = cli.takeInput("Enter ID of player who wants to play: ");
            cli.display(null);

            if (manager.getPlayer(playerToAdd) == null) {
                cli.display("Invalid input. Please enter a valid ID.");
                cli.display(null);
                continue;
            } else {
                if(!game.addPlayer(playerToAdd)) {
                    cli.display("Player already added. Please enter a different ID.");
                    cli.display(null);
                    continue;
                }
                String command = cli.takeInput("press P to add more players or any key to continue...");
                if (command.toLowerCase() != "p") {
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
