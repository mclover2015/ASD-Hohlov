import java.util.Scanner;

public class lb4 {

    public static void start(Scanner scanner) {
        System.out.print("Enter number of people: ");
        int n = scanner.nextInt();
        System.out.print("Enter step size: ");
        int k = scanner.nextInt();
        System.out.println("Last remaining person is at position: " + josephus(n, k));
    }


    private static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (josephus(n - 1, k) + k) % n;
    }
}
