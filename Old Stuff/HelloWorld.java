import java.util.Arrays;
import java.util.Scanner;


public class HelloWorld {

    public static void main(String[] args){
        int data[];
        Scanner in = new Scanner(System.in);
        data = new int[10];
        System.out.println("Please Insert Numbers : ");
        String line = in.nextLine();
        String[] stringsNumber = line.split("\\s");
        for(int i=0;i<stringsNumber.length;i++){
            if(stringsNumber[i].matches("^\\d+$") && i<10){// \\d  is a regex to verify if s is a number

                data[i]= Integer.parseInt(stringsNumber[i]);

            }

        }
        System.out.println(Arrays.toString(data));
    }
}