import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
        int stateId = 0;
        boolean quitGame = false;
        System.out.println("       __\n" + "      / /__  ____________  __ \n"+ " __  / / _ \\/ ___/ ___/ / / /\n" + "/ /_/ /  __/ /  / /  / /_/ / \n" + "\\____/\\___/_/  /_/   \\__  / \n" + "                    /____/ " + "\n\nby: Levent Koca\n");
        while (!quitGame) {
            System.out.print("What is your name?");
            String userName = getInput();
            System.out.print("Hello " + userName + "!\n");
            age();
            gameStart();
            printState(stateId);
            String action = getInput();
            stateId = takeAction(action, stateId);
            if (action.equalsIgnoreCase("quit")){
                stateId = 666;
            }
            if (stateId == 666) {
                quitGame = true;
                System.out.println("Thanks for playing! Goodbye.");
            }
        }
    }


    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a valid response: ");
        String input = scanner.nextLine();
        input = input.toLowerCase().replaceAll("\\s","");
        return input;
    }



    public static int takeAction(String action, int currentState) {
        switch (currentState) {
            case 0:
                if (action.equals("open the door")) {
                    return 1;
                } else if (action.equals("take item")) {
                    return 2;
                }
                break;
            case 1:
                if (action.equals("go east")) {
                    return 3;
                }
                break;
            default:
                break;
        }
        
        return currentState; // Stay in the current state if no valid action found
    }

    public static boolean isValidAction(String action) {
        String[] validActions = {
            "open the door",
            "go north",
            "go east",
            "go south",
            "go west",
            "take item",
            "drop item",
            "use item",
            "quit"  // Allow the user to quit the game
        };

        for (String valid : validActions) {
            if (action.equals(valid)) {
                return true;
            }
        }

        return false;
    }

    public static void printState(int stateId) {
        switch (stateId) {
            case 0:
                System.out.println("\nYou are standing in an abandoned university office. There are neither students nor teachers around you. There’s a table in front of you with various papers, pens, a small puzzle toy, and a calculator.");
                System.out.println("A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor.");
                System.out.println("You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.");
                break;
            case 1:
                System.out.println("You are in a long hallway. There’s a man wearing glasses at the end of it, he looks harmless. West is a wall, east is the man, to the north is nothing but empty offices, a desperate sight. The carpeting in the hallway feels soft, you hear the clicking of a mouse in the distance. Your office is south (behind you).");
                break;
            case 2:
                System.out.println("You take the calculator from your desk. It’s a Casio FX-85gt Plus. The display shows the number 0.1134. You turn it upside down; now the Casio greets you with a friendly “hello”, nice. You hold the calculator in your hand.");
                break;
            case 3:
                System.out.println("The man greets you and starts endlessly talking to you about his children and his holiday to Benidorm. You die of boredom.");
                break;
            default:
                break;
        }
    }


    public static void age() {
    while (true) {
        System.out.print("\nWhat year were you born?");
        String bday1 = getInput();
        try {
            int number = Integer.parseInt(bday1);
            if (number < 2023) {
                System.out.print("You are " + (2023 - number) + " years old!");
                if (2023 - number >= 100) {
                    if ((2023 - number) >= 130) {
                        System.out.println(" You must be a wizard!");
                        break;
                    } else {
                        System.out.println(" You are really old");
                        break;
                    }
                }
            } else if (number == 2023) {
                System.out.println("You were born this year, you are 0 years old!");
                break;
            } else if (number > 2023) {
                randomNotBornYet();
                age();
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println(bday1 + " is not a valid answer, try a number instead!");
            age();
            break;
        }
    }
}

    
    public static void waitTime(){
        int delay = 5000; // number of milliseconds to sleep
        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - delay);
    }
        

    public static void randomString() {
            String[] random_answer = {"Ok, tell me when you want to start!", "Oh ok I'll wait, like I have nothing to do anyways!", "Oh yea sure, I'll wait, but hurry up maybe!", "Can you hurry up, you are wasting my time!"};
            Random random = new Random();
            int index = random.nextInt(random_answer.length);
            System.out.println(random_answer[index]);
            gameStart();
        }


    public static void randomNotBornYet() {
            String[] random_answer = {"How are you not born? Give give a valid answer!", "Haha, yes you are definately not born yet, now;", "...   cmon, really?", "We have a joker here, come on tell me!"};
            Random random = new Random();
            int index = random.nextInt(random_answer.length);
            System.out.println(random_answer[index]);
        }


    public static void gameStart() { 

                System.out.print("\nWould you like to start the game?: ");
                String answer1 = getInput();
                answer1 = answer1.toLowerCase();
            
            if (answer1.equals("yes") || answer1.equals("continue") || answer1.equals("start") || answer1.equals("go") || answer1.equals("play") || answer1.equals("sure") || answer1.equals("yea")){
                System.out.println("Ok, get ready!");
                waitTime();
            } else if (answer1.equals("no") || answer1.equals("nah") || answer1.equals("later")) {
                randomString();
            } else if (answer1.equals("maybe") || answer1.equals("idk") || answer1.equals("i dont know")) {
                System.out.print("What does that even mean? Make up your mind!\n");
                gameStart();
            } else {
                System.out.print("I... I dont know what that means!\n");
                gameStart();
            }
        
    }


}



