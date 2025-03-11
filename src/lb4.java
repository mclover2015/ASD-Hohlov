import java.util.Scanner;

public class lb4 {

    // Function to find the position of the last remaining person
    public static int josephus(int n, int k) {
        int result = 0;  // Base case: if there's only one person, they are the last one remaining.

        // Iterate to calculate the position for each value of n, from 2 to n
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }

        return result;  // The position of the last person in 0-based indexing
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of people and the step size (k)
        System.out.print("Enter the number of people (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the step size (k): ");
        int k = scanner.nextInt();

        // Find the position of the last remaining person
        int lastPerson = josephus(n, k);

        // Output the result (convert from 0-based to 1-based index)
        System.out.println("The position of the last remaining person is: " + (lastPerson + 1));

        scanner.close();
    }
}
