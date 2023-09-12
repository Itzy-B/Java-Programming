import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("       __\n" + "      / /__  ____________  __ \n"+ " __  / / _ \\/ ___/ ___/ / / /\n" + "/ /_/ /  __/ /  / /  / /_/ / \n" + "\\____/\\___/_/  /_/   \\__  / \n" + "                    /____/ " + "\n\nby: Levent Koca\n");
        System.out.print("What is your name?: ");
        String userName = scanner.nextLine();
        System.out.print("Hello " + userName + "!\n");
        age();
        gameStart();
    }


    public static void age() {
        while (true){ 
        System.out.print("\nWhat year were you born?: ");
        String bday1 = scanner.nextLine().toLowerCase(); 
            try {
                int number = Integer.parseInt(bday1);
                    if (number < 2023) {
                        System.out.print("You are " + (2023 - number) + " years old!");
                        if (2023 - number >= 100) {
                            if ((2023 - number) >= 130){
                                System.out.println(" You must be a wizard!");
                                break;
                            } else {
                                System.out.println(" You are really old");
                                
                            }
                        break;
                        }
                        } else if (number == 2023) {
                            System.out.println("You were born this year, you are 0 years old!");
                            break;
                        } else if (number > 2023){
                            randomNotBornYet();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(bday1 + " is not a valid answer, try a number instead!");//System.out.println("This is an invalid year! You are not born yet!");
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
                String answer1 = scanner.nextLine();
                answer1 = answer1.toLowerCase();
            
            if (answer1.equals("yes") || answer1.equals("continue") || answer1.equals("start") || answer1.equals("go") || answer1.equals("play") || answer1.equals("sure") || answer1.equals("yea")){
                System.out.println("Ok, get ready!");
                game(); // Learn to pause the code for 5 secs
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


    public static void gameFirstStep() {
            System.out.println("\n\nGame Instructions!:\n\nYou are standing in an abandoned university office. There are neither students nor teachers around you. There's a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.");
            System.out.print("\nPlease fill in a command!: ");
            String answer2 = scanner.nextLine();
            answer2 = answer2.toLowerCase();
            while(true) {
            if (answer2.equalsIgnoreCase("Open the door")) {
                gameFirstStep();
            } else {
            // Handle the case when the input doesn't match any valid option
                System.out.println("\nThat's not a valid option. Try something else.");
                break;
            }
        }
    }

// fix these two
    public static void game(){
        waitTime();
        gameFirstStep();

    }

}



