import java.util.Scanner;

public class lb1 {

    public static void start(Scanner scanner) {

        System.out.println("enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the elements:");


        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        int evenCount = 0, oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of even elements: " + evenCount);
        System.out.println("Number of odd elements: " + oddCount);
    }
}
