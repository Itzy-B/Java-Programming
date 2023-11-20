import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static int stateId = 0;
    public static final String Green = "\u001B[32m";
    public static final String Yellow = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String Cyan = "\u001B[36m";

    public static void main(String[] args) {
        String[] stories = new String[6]; // Increased the size to accommodate the new stories
        stories[0] = ("\n1) " + Green + "You are standing in an abandoned university office. There are neither students nor teachers around you. There's a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice." + RESET);
        stories[1] = ("\n2) " + Green + "You are in a long hallway. There's a man wearing glasses at the end of it, he looks harmless. West is a wall, east is the man, to the north is nothing but empty offices, a desperate sight. The carpeting in the hallway feels soft, you hear the clicking of a mouse in the distance. Your office is south (behind you)." + RESET);
        stories[2] = ("\n3) " + Green + "You take the calculator from your desk. It's a Casio FX-85gt Plus. The display shows the number 0.1134. You turn it upside down; now the Casio greets you with a friendly “hello”, nice. You hold the calculator in your hand." + RESET);
        stories[3] = ("\n4) " + Green + "The man greets you and starts endlessly talking to you about his children and his holiday to Benidorm. You die of boredom." + RESET);
        stories[4] = ("\n5) " + Green + "You enter the hallway with the Casio FX-85gt stand-by. Having this small device greet you puts you in a good mood, somehow the building feels less lonely than before. West is a wall, looking east you stare into the darkness, the corridor is too long to see the end. To the north you see an office with what looks like a small creature in a corner. The carpeting in the hallway feels soft, you hear someone explaining algorithms to your north." + RESET);
        stories[5] = ("\n6) " + Green + "You enter the office. To your surprise a small dog is sitting in the corner. Surely this breaks any number of university regulations! In a high-pitched voice the dog tells you how to write even more cool words on your Casio FX-85gt, good boi! To the north you see an open window, a ladder hangs down from it, it looks so dangerous! An LCD display shows a youtube video about developing algorithms." + RESET);

        System.out.println(Cyan +
            "	         __                    _          ___       __                 __                 \n"
                    + "		/ /__  ____________  _( )_____   /   | ____/ /   _____  ____  / /___  __________  \n"
                    + "	   __  / / _ \\/ ___/ ___/ / / /// ___/  / /| |/ __  / | / / _ \\/ __ \\/ __/ / / / ___/ _ \\\n"
                    + "	  / /_/ /  __/ /  / /  / /_/ / (__  )  / ___ / /_/ /| |/ /  __/ / / / /_/ /_/ / /  /  __/ \n"
                    + "	  \\____/\\___/_/  /_/   \\__, / /____/  /_/  |_\\__,_/ |___/\\___/_/ /_/\\__/\\__,_/_/   \\___/  \n"
                    + "			      /____/  	\n\nby: Levent Koca\n" + RESET);
        System.out.print(Cyan + "What is your name? " + RESET);
        String userName = getInput();
        if (userName.equalsIgnoreCase("exit") || userName.equalsIgnoreCase("quit")) {
            System.out.println(Cyan + "Thanks for playing. Goodbye!" + RESET);
            System.exit(0);
        } else {
            System.out.println(Cyan + "Hello " + RESET + userName + Cyan + "!\n" + RESET);
        }
        age();
        gameStart();

        // Define the state transition matrix
        int[][] stateTransitionMatrix = {
            {1, 2, -1, -1, -1, -1}, // State 0 transitions
            {0, -1, 3, -1, -1, -1}, // State 1 transitions
            {-1, -1, -1, -1, 4, 5}, // State 2 transitions
            {-1, -1, -1, -1, -1, -1}, // State 3 transitions
            {-1, 1, -1, 0, -1, -1}, // State 4 transitions
            {-1, -1, -1, -1, -1, -1}  // State 5 transitions
        };

        while (stateId != 666) {
            printState(stateId, stories);
            stateId = takeAction(stateId, stateTransitionMatrix);
        }

        System.out.println(Cyan + "Thanks for playing. Goodbye!" + RESET);
    }
        
    public static String getInput() {
        System.out.print(Yellow + "Enter a valid response: " + RESET);
        String input = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
        return input;
    }

    public static int takeAction(int currentState, int[][] stateTransitionMatrix) {
        String action = getInput();
        int newState = -1;

        switch (action) {
            case "openthedoor":
                newState = stateTransitionMatrix[currentState][0];
                break;
            case "takeitem":
                newState = stateTransitionMatrix[currentState][1];
                break;
            case "gonorth":
                newState = stateTransitionMatrix[currentState][2];
                break;
            case "goeast":
                newState = stateTransitionMatrix[currentState][3];
                break;
            case "dropitem":
                newState = stateTransitionMatrix[currentState][4];
                break;
            case "gosouth":
                newState = stateTransitionMatrix[currentState][5];
                break;
            case "quit":
                return 666;
            case "exit":
                return 666; // Special value to exit the game
            default:
                System.out.println(Cyan + "\nInvalid action. Try something else." + RESET);
                break;
        }

        if (newState != -1) {
            return newState;
        } else {
            System.out.println(Cyan + "You can't do that right now." + RESET);
            return currentState;
        }
    }

    public static void gameStart() {
        System.out.print(Cyan + "\nWould you like to start the game? (yes/no): " + RESET);
        String answer1 = getInput();
        if (answer1.equalsIgnoreCase("yes") || answer1.equals("y")) {
            System.out.println(Cyan + "Ok, get ready!" + RESET);
            waitTime();
        } else if (answer1.equalsIgnoreCase("no") || answer1.equals("n") || answer1.equals("exit") || answer1.equalsIgnoreCase("quit")) {
            stateId = 666;
        } else {
            System.out.println(Cyan + "I don't understand. Please enter 'yes' or 'no'." + RESET);
            gameStart();
        }
    }

    public static void age() {
        while (true) {
            System.out.print(Cyan + "What year were you born? " + RESET);
            String bday1 = getInput();
            try {
                int number = Integer.parseInt(bday1);
                if ((number < 2023)) {
                    System.out.print(Cyan + "You are " + RESET + (2023 - number) + Cyan + " years old!" + RESET);
                    if ((2023 - number) >= 130) {
                        System.out.println(Cyan + " You must be a wizard!" + RESET);
                        return;
                    } else {
                        System.out.println(Cyan + " You are really old" + RESET);
                        return;
                    }
                } else if (number == 2023) {
                    System.out.println(Cyan + "You were born this year, you are 0 years old! " + RESET);
                    return;
                } else if (number > 2023) {
                    randomNotBornYet();
                    age();
                    return;
                }
                return;
            } catch (NumberFormatException e) {
                if (bday1.equalsIgnoreCase("exit") || bday1.equalsIgnoreCase("quit")) {
                    System.out.println(Cyan + "Thanks for playing. Goodbye!" + RESET);
                    System.exit(0);
                    return;
                } else {
                    System.out.println(bday1 + Cyan + " is not a valid answer, try a number instead!\n" + RESET);
                    age();
                    return;
                }
            }
        }
    }

    public static void waitTime() {
        int delay = 3500;
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - delay) ;
    }

    public static void randomNotBornYet() {
        String[] random_answer = {
                Cyan + "How are you not born? Give give a valid answer!",
                "Haha, yes you are definitely not born yet, now;",
                "...   cmon, really?",
                "We have a joker here, come on tell me!" + RESET
        };
        Random random = new Random();
        int index = random.nextInt(random_answer.length);
        System.out.println(random_answer[index]);
    }

    public static void printState(int stateId, String[] storyArray) {
        System.out.println(storyArray[stateId]); // Use the stories array to print the story for the given stateId
    }

    //THE FINAL TASK IS WRITTEN BELOW INCLUDING THE MAIN FUNCTION BUT IS COMMANTED OUT!
    /*
    public static void main(String[] args) {

        String [][] transitionMatrix = new String[6][6]; 
            for (int i = 0; i < transitionMatrix.length; i++) {
                for (int j = 0; j < transitionMatrix.length; j++) {
                    transitionMatrix[i][j] = ""; 
                }
            }

            transitionMatrix[0][1] = "open the door";
            transitionMatrix[0][2] = "take item";
            transitionMatrix[1][0] = "go south";
            transitionMatrix[1][3] = "go east";
            transitionMatrix[2][4] = "open the door";
            transitionMatrix[4][1] = "drop item";
            transitionMatrix[4][5] = "go north";
            transitionMatrix[5][1] = "go south";


        String [] storyArray = {"You are standing in an abandoned university office. There are neither students nor teachers around you. There’s a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.", 
                                "You are in a long hallway. There’s a man wearing glasses at the end of it, he looks harmless. West is a wall, east is the man, to the north is nothing but empty offices, a desperate sight. The carpeting in the hallway feels soft, you hear the clicking of a mouse in the distance. Your office is south (behind you).",
                                "You take the calculator from your desk. It’s a Casio FX-85gt Plus. The display shows the number 0.1134. You turn it upside down; now the Casio greets you with a friendly “hello”, nice. You hold the calculator in your hand.",
                                "The man greets you and starts endlessly talking to you about his children and his holiday to Benidorm. You die of boredom.",
                                "You enter the hallway with the Casio FX-85gt stand-by. Having this small device greet you puts you in a good mood, somehow the building feels less lonely than before. West is a wall, looking east you stare into the darkness, the corridor is too long to see the end. To the north you see an office with what looks like a small creature in a corner. The carpeting in the hallway feels soft, you hear someone explaining algorithms to your north.",
                                "You enter the office. To your surprise a small dog is sitting in the corner. Surely this breaks any number of university regulations! In a high-pitched voice the dog tells you how to write even more cool words on your Casio FX-85gt, good boi! To the north you see an open window, a ladder hangs down from it, it looks so dangerous! An LCD display shows a youtube video about developing algorithms."}; 
 



        tellStory(0, transitionMatrix, storyArray, new boolean[6]);
    }

    
    
    
    public static void tellStory(int state, String[][] transMatrix, String[] stateArray, boolean[] visited){

        System.out.println(stateArray[state]);
        System.out.println();
        visited[state] = true;

        for (int i = 0; i < transMatrix[state].length; i++) {
            if(!transMatrix[state][i].equalsIgnoreCase("")){
                
                if(visited[i] == false){
                    System.out.println(transMatrix[state][i]);
                    tellStory(i, transMatrix, stateArray, visited);

                }
            }
        }

    } */
}