import models.Game;
import services.CLI;
import services.GameService;
import services.PlayerManager;

public class App {
    public static void main(String[] args) throws Exception {
        CLI cli = CLI.getCli();
        PlayerManager manager = PlayerManager.getManager();
        GameService service = GameService.getGameService();

        cli.display("Welcome to Snake and Ladder Game!!");
        cli.display(null);
        cli.takeInput("press any key to continue...");
        cli.display(null);

        while(true) {
            String command;
            while(true) {
                command = cli.takeInput("Press P to create Player or S to to setup new Game");
                if(command.toLowerCase() != "p" || command.toLowerCase() != "s") {
                    cli.display(null);
                    cli.display("Wrong input!! Please press correct key.");
                    cli.display(null);
                } else {
                    break;
                }
            }
            
            if(command.toLowerCase() == "p") {
                String playerName = cli.takeInput("Let's create a Player. Enter new player's name: ");
                String playerId = manager.createPlayer(playerName);
                cli.display(null);
                cli.display(String.format("Player %s created with id: %s", playerName, playerId));
                cli.display(null);
            }
            if(command.toLowerCase() == "s") {
                Game game = service.createGame();
                game.startGame();
                String winnerID = game.getWinner();
                cli.display(String.format("This game's winner is: %s", manager.getPlayer(winnerID)));
                cli.display(null);
            }

            command = cli.takeInput("press Q to quit or any other key to play again");
            if(command.toLowerCase() == "q") {
                break;
            }
        }
    }
}


// Entities

// - Player
// - Board
// - Snake
// - Ladder
// - Dice
// - Game

// Functional Requirements

// - Game rules

// Non Functional Requirements

// - Selectable borad size
// - Multiple Players
// - Can roll multiple dices in one go
// - Players can quit any time - not handled in this application

// Services and Managers

// - PlayerManager
// - GameService


