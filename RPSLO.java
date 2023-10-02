import java.util.Random;
import java.util.Scanner;

public class RPSLO {

    // Rock = 0, Paper = 1, Scissors = 2, Lizzard = 3, Spock = 4
    // Scissors cut Paper
    // Paper covers Rock
    // Rock crushes Lizard
    // Lizard poisons Spock
    // Spock smashes Scissors
    // Scissors decapitate Lizard
    // Lizard eats Paper
    // Paper disproves Spock
    // Spock vaporizes Rock
    // Rock crushes Scissors

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter your play: R, P, S, L, O");
        char userInput = scanner.next().toUpperCase().charAt(0);
        
        if (userInput != 'R' && userInput != 'P' && userInput != 'S' && userInput != 'L' && userInput != 'O'){
            System.out.println("Invalid input (valid inputs: R, P, S, L, O)");
        } else {
            int compChoice = random.nextInt(5);

            char computerPlay;
            switch(compChoice){
                case 0:
                    computerPlay = 'R';
                    break;
                case 1:
                    computerPlay = 'P';
                    break;
                case 2:
                    computerPlay = 'S';
                    break;
                case 3:
                    computerPlay = 'L';
                    break;
                default:
                    computerPlay = 'O';
                    break;
            }
            System.out.println("Computer play is " + computerPlay);

            if (userInput == computerPlay) {
                System.out.println("It is a tie!");
            } else if (
                (userInput == 'R' && (computerPlay == 'L' || computerPlay == 'S')) ||
                (userInput == 'P' && (computerPlay == 'R' || computerPlay == 'O')) ||
                (userInput == 'S' && (computerPlay == 'P' || computerPlay == 'L')) ||
                (userInput == 'L' && (computerPlay == 'O' || computerPlay == 'P')) ||
                (userInput == 'O' && (computerPlay == 'R' || computerPlay == 'S'))
            ) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }
    }
}