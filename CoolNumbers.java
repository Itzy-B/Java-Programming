import java.util.*;
import java.util.Scanner;

public class CoolNumbers {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    

    }
    public static boolean isCool(int x, int n, int a, int b) {
        System.out.print("Enter a positive integer : ");
        a = scanner.nextInt();
        while (true){
        
        if (a > 0){
            System.out.print("Enter another positive integer: ");
            b = scanner.nextInt();
            if (b > 0) {
                break;
            }else {
                System.out.print("Invalid, please enter a \"POSITIVE\" \", INTEGER!\"");
                isCool(x, n, a, b);
            }
        } else{
          System.out.print("Invalid, please enter a \"POSITIVE\" \", INTEGER!\"");
          isCool(x, n, a, b);
            }
        }
        
    }

    /* public static int countCools(int n, int a, int b) {
     // your code here
    } */


    
}