import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static int stateId = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Adventure Game by Levent Koca\n");
        System.out.print("What is your name? ");
        String userName = getInput();
        if (userName.equalsIgnoreCase("exit") || userName.equalsIgnoreCase("quit")) {
            System.out.println("Thanks for playing. Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Hello " + userName + "!\n");
        }
        age();
        gameStart();

        while (stateId >= 0) {
            printState(stateId);
            stateId = takeAction();
            
        }

        System.out.println("Thanks for playing. Goodbye!");
    }

    public static String getInput() {
        System.out.print("Enter a valid response: ");
        String input = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
        if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
            System.out.println("Thanks for playing. Goodbye!");
            System.exit(0);
        }
        return input;
    }

    public static int takeAction() {
        String action = getInput();
        switch (action) {
            case "open the door":
                return stateId = 1;
            case "take item":
                stateId = 2;
                return stateId = 2;
            case "go east":
                return stateId = 1;
            default:
                System.out.println("Invalid action. Try something else.");
                return stateId = 0;
        }
    }

    public static void printState(int stateId) {
        switch (stateId) {
            case 0:
                System.out.println("\nYou are standing in an abandoned university office. There are neither students nor teachers around you.");
                System.out.println("There’s a table in front of you with various papers, pens, a small puzzle toy, and a calculator.");
                System.out.println("A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell).");
                System.out.println("Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor.");
                System.out.println("You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance.");
                System.out.println("You are not thirsty, but you rather have a craving for justice.\n");
                return;
            case 1:
                System.out.println("You are in a long hallway. There’s a man wearing glasses at the end of it, he looks harmless. West is a wall, east is the man, to the north is nothing but empty offices, a desperate sight.");
                System.out.println("The carpeting in the hallway feels soft, you hear the clicking of a mouse in the distance. Your office is south (behind you).");
                return;
            case 2:
                System.out.println("You take the calculator from your desk. It’s a Casio FX-85gt Plus. The display shows the number 0.1134. You turn it upside down; now the Casio greets you with a friendly “hello”, nice. You hold the calculator in your hand.");
                return;
            case 3:
                System.out.println("The man greets you and starts endlessly talking to you about his children and his holiday to Benidorm. You die of boredom.");
                return;
            default:
                return;
        }
    }

    public static void gameStart() {
        System.out.print("\nWould you like to start the game? (yes/no): ");
        String answer1 = getInput();
        if (answer1.equalsIgnoreCase("yes") || answer1.equals("y")) {
            System.out.println("Ok, get ready!");
            waitTime();
        } else if (answer1.equalsIgnoreCase("no") || answer1.equals("n") || answer1.equals("exit") || answer1.equalsIgnoreCase("quit")) {
            System.out.println("Thanks for playing. Goodbye!");
            System.exit(0);
        } else {
            System.out.println("I don't understand. Please enter 'yes' or 'no'.");
            gameStart();
        }
    }

    public static void age() {
        while (true) {
            System.out.print("What year were you born? ");
            String bday1 = getInput();
            try {
                int number = Integer.parseInt(bday1);
                if ((number < 2023)) {
                    System.out.print("You are " + (2023 - number) + " years old!");
                    if ((2023 - number) >= 130) {
                        System.out.println(" You must be a wizard!");
                        return;
                    } else {
                        System.out.println(" You are really old");
                        return;
                    }
                } else if (number == 2023) {
                    System.out.println("You were born this year, you are 0 years old! ");
                    return;
                } else if (number > 2023) {
                    randomNotBornYet();
                    age();
                    return;
                }
                return;
            } catch (NumberFormatException e) {
                if (bday1.equalsIgnoreCase("exit") || bday1.equalsIgnoreCase("quit")) {
                    System.out.println("Thanks for playing. Goodbye!");
                    System.exit(0);
                    return;
                } else {
                    System.out.println(bday1 + " is not a valid answer, try a number instead!\n");
                    age();
                    return;
                }
            }
        }
    }

    public static void waitTime() {
        int delay = 3500;
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - delay);
    }

    public static void randomNotBornYet() {
        String[] random_answer = {
            "How are you not born? Give give a valid answer!",
            "Haha, yes you are definitely not born yet, now;",
            "...   cmon, really?",
            "We have a joker here, come on tell me!"
        };
        Random random = new Random();
        int index = random.nextInt(random_answer.length);
        System.out.println(random_answer[index]);
    }
}
