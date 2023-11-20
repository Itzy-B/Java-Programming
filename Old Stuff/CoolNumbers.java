import java.util.Scanner;

public class CoolNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        System.out.print("Enter a: ");
        int a = scanner.nextInt();

        System.out.print("Enter b: ");
        int b = scanner.nextInt();

        int count = countCools(n, a, b);
        System.out.println("Number of cool numbers between " + a + " and " + b + " with n=" + n + ": " + count);

        scanner.close();
    }

    public static boolean isCool(int x, int n) {

        if (x <= 0 || n <= 0) {
            System.out.print("The values should be bigger than 0, thus ");
            return false;
        }

        int temp = x;
        while (temp != 0) {
            int digit = temp % 10;
            if (digit == 0 || n % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public static int countCools(int n, int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isCool(i, n)) {
                count++;
            }
        }
        return count;
    }
}