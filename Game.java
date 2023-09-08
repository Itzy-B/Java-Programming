import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);

    public static void age() {
        System.out.print("What year were you born?: ");
        int bday1 = scanner.nextInt();
        
        if (bday1 < 2023) {
            System.out.print("You are " + (2023 - bday1) + " years old!");
            if (2023 - bday1 >= 100) {
                System.out.println(" You must be a wizard!");
            }
        } else if (bday1 == 2023) {
            System.out.println("You were born this year!");
        } else if (bday1 > 2023) {
            System.out.println("This is an invalid year! You are not born yet!");
        } else {
            System.out.println("Invalid character, try using numbers!");
        }
    }

    public static void gameStart() { // get two functions out of this! make one that starts the game and one that is called for the game!

    while(true){
        System.out.print("\nWould you like to start the game?");
        String answer1 = scanner.nextLine();

        switch(answer1.toLowerCase()){
            case "yes":
                game();
            case "no":
                System.out.println("Ok, tell me when you want to start!");
                break;
    
        }
    }

        /*String a1 = "Yes";
        String a2 ="No";
        String a3 = "Maybe";
        if (answer1.equalsIgnoreCase(a1)){
            game();
        }else if (answer1.equalsIgnoreCase(a2)){
            System.out.println("Ok, tell me when you want to start!");
        }else if (answer1.equalsIgnoreCase(a3)){
            System.out.println("What? ... What does that mean? Is that a yes or no?");
        }else {
            System.out.println("That isn't even an answer to the question!");
        }*/
       
    }
    
    
    
    public static void main(String[] args) {
        System.out.println("       __\n" + "      / /__  __________ __  __ \n"+ " __  / / _ \\/ ___/ ___// / / /\n" + "/ /_/ /  __/ /  / /   / /_/ / \n" + "\\____/\\___/_/  /_/    \\__  / \n" + "                     /____/ " + "\n\nby: Levent Koca\n");
        System.out.print("What is your name?: ");
        String userName = scanner.nextLine();
        System.out.print("Hello " + userName + "!\n");
        age();
        gameStart();
    }


    public static void game(){
        System.out.println("\n\nYou are standing in an abandoned university office. There are neither students nor teachers around you. There's a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.");
            String answer2 = scanner.nextLine();
            if (answer2.equalsIgnoreCase("Open the door")) {
            // Your code for opening the door goes here
            } else {
            // Handle the case when the input doesn't match any valid option
            System.out.println("\nThat's not a valid option. Try something else.");
            }
    }


}



