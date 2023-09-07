import java.util.Scanner; 

public class Game {
	private static Scanner scanner;

    public static void main(String[] args) {
		scanner = new Scanner(System.in);
		// ----- Write your code below
        System.out.print("by: Levent Koca\n\n");
        System.out.print("What is your name?: ");
        String userName = scanner.nextLine();
        System.out.print("Hello " + userName + "! \n");
        System.out.print("What year were you born?: ");
        String bday = scanner.nextLine();
        int bday1 = Integer.parseInt(bday);
        System.out.print("You are " + (2023 - bday1) + " years old!");
		// ----- Write your code above
	}
    
}  

