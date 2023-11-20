import java.util.Scanner;

public class GameStudent {

    public static Scanner myScanner = new Scanner(System.in); 
    public static int stateID = 0; 


    /* 
    public static void main(String[] args) {


        System.out.println(
            "	         __                    _          ___       __                 __                 \n"
                    + "		/ /__  ____________  _( )_____   /   | ____/ /   _____  ____  / /___  __________  \n"
                    + "	   __  / / _ \\/ ___/ ___/ / / /// ___/  / /| |/ __  / | / / _ \\/ __ \\/ __/ / / / ___/ _ \\\n"
                    + "	  / /_/ /  __/ /  / /  / /_/ / (__  )  / ___ / /_/ /| |/ /  __/ / / / /_/ /_/ / /  /  __/ \n"
                    + "	  \\____/\\___/_/  /_/   \\__, / /____/  /_/  |_\\__,_/ |___/\\___/_/ /_/\\__/\\__,_/_/   \\___/  \n"
                    + "			      /____/  	\n\nby: Gui\n");


        System.out.println("What's your name?: "); 
        String name = myScanner.nextLine(); 
        System.out.println("Hi " + name); 

        System.out.println("What year were you born?: "); 
        int yearOfBirth = myScanner.nextInt(); 
        int age = calculateAge(yearOfBirth); 

        System.out.println("You are "+ age + " years old. ");



        String [] storyArray = {"You are standing in an abandoned university office. There are neither students nor teachers around you. There’s a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.", 
                                "You are in a long hallway. There’s a man wearing glasses at the end of it, he looks harmless. West is a wall, east is the man, to the north is nothing but empty offices, a desperate sight. The carpeting in the hallway feels soft, you hear the clicking of a mouse in the distance. Your office is south (behind you).",
                                "You take the calculator from your desk. It’s a Casio FX-85gt Plus. The display shows the number 0.1134. You turn it upside down; now the Casio greets you with a friendly “hello”, nice. You hold the calculator in your hand.",
                                "The man greets you and starts endlessly talking to you about his children and his holiday to Benidorm. You die of boredom.",
                                "You enter the hallway with the Casio FX-85gt stand-by. Having this small device greet you puts you in a good mood, somehow the building feels less lonely than before. West is a wall, looking east you stare into the darkness, the corridor is too long to see the end. To the north you see an office with what looks like a small creature in a corner. The carpeting in the hallway feels soft, you hear someone explaining algorithms to your north.",
                                "You enter the office. To your surprise a small dog is sitting in the corner. Surely this breaks any number of university regulations! In a high-pitched voice the dog tells you how to write even more cool words on your Casio FX-85gt, good boi! To the north you see an open window, a ladder hangs down from it, it looks so dangerous! An LCD display shows a youtube video about developing algorithms."}; 
 

        myScanner.nextLine(); 
        
        while (stateID != 666) {
            System.out.println(getStory(stateID, storyArray));
            String action = getInput();
            takeAction(action, stateID);
        }
  
        myScanner.close(); 
    
    }
    */

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

    }

























    public static String getStory(int stateId, String [] storyArray){
        return storyArray[stateId]; 
    }

    public static int calculateAge(int year){
        return 2023 - year;  
    }

    public static String [] moves = { "open the door", "go north", "go east", "go south", "go west", "take item", "drop item", "use item", "quit" };

    public static String getInput(){
        String action  = ""; 
        boolean isValid = false; 

        while(isValid == false){        // !isValid - Does the same thing as == false. Read it: Not isValid. 

            System.out.println("What would you like to do: "); 
            action = myScanner.nextLine(); 


            for (int i = 0; i < moves.length; i++) {
                if(moves[i].equalsIgnoreCase(action)){
                    isValid = true; 
                }
            }

        }
        return action;         
    }

    public static int takeAction(String input, int currentState){

        if(input.equalsIgnoreCase("quit")){
            stateID = 666; 
        } else{
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

            for (int i = 0; i < transitionMatrix.length; i++) {
                if(transitionMatrix[currentState][i].equalsIgnoreCase(input)){
                    stateID = i;
                }
            }

        }
        return stateID; 

         
    }
}
