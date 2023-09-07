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
    int a = (int) amount, b, c, d;

    a = (int) amount;
    b = (int) ((amount - a) / 0.49);
    c = (int) (((amount - a) - (b * 0.49)) / 0.09);
    d = (int) (((amount - a) - (b * 0.49) - (c * 0.9)) / 0.01);

    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
}
}
