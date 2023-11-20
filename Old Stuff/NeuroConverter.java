import java.util.Scanner;
public class NeuroConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        converter(amount);
}

public static void converter(double amount) {
    int amountInt = (int) amount;
    amountInt = amountInt * 100;
    amount *= 100;
    int a, b, c, d;
    a = (int) amount;
    b = (int) ((amount - amountInt) / 49);
    c = (int) (((amount - amountInt) - (b * 49)) / 9);
    d = (int) (((amount - amountInt) - (b * 49) - (c * 9)) / 1);

    System.out.println(a/100);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
}
}
