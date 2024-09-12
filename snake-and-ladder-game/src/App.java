import services.CLI;

public class App {
    public static void main(String[] args) throws Exception {
        CLI cli = CLI.getCli();

        cli.display("Welcome to Snake and Ladder Game!!");
        cli.display(null);
        cli.takeInput("press any key to continue...");
        cli.display(null);

        while(true) {
            String command;
            while(true) {
                command = cli.takeInput("Press P to create Player or S to to setup Game");
                if(command.toLowerCase() != "p" || command.toLowerCase() != "s") {
                    cli.display(null);
                    cli.display("Wrong input!! Please press correct key.");
                    cli.display(null);
                } else {
                    break;
                }
            }
            
            if(command == "p") {
                String playerName = cli.takeInput("Let's create a Player. Enter new player's name: ");
                
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

// Functional Requirements

// - Game rules

// Non Functional Requirements

// - Selectable borad size
// - Multiple Players
// - Game End Condition
// - Can roll multiple dices in one go
// - Players can quit any time

// Services and Managers

// - PlayerManager
// - GameService
// - DiceService


