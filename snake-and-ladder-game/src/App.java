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
        cli.display("");
        cli.takeInput("press any key to continue...");
        cli.display("");

        while(true) {
            String command;
            while(true) {
                command = cli.takeInput("Press P to create Player or S to to setup new Game");
                if(!command.equalsIgnoreCase("p") && !command.equalsIgnoreCase("s")) {
                    cli.display("");
                    cli.display("Wrong input!! Please press correct key.");
                    cli.display("");
                } else {
                    break;
                }
            }
            
            if(command.equalsIgnoreCase("p")) {
                String playerName = cli.takeInput("Let's create a Player. Enter new player's name: ");
                String playerId = manager.createPlayer(playerName);
                cli.display("");
                cli.display(String.format("Player %s created with id: %s", playerName, playerId));
                cli.display("");
            }
            if(command.equalsIgnoreCase("s")) {
                if (manager.getNumberOfPlayers() < 2) {
                    cli.display("Not enough players. Minimum 2 players required.");
                    cli.display("");
                    continue;
                }
                Game game = service.createGame();
                game.startGame();
                String winnerID = game.getWinner();
                cli.display(String.format("This game's winner is: %s", manager.getPlayer(winnerID)));
                cli.display("");
            }

            command = cli.takeInput("press Q to quit or enter to add more players and start new game");
            if(command.equalsIgnoreCase("q")) {
                break;
            }
        }
    }
}