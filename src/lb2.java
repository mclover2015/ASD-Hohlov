import java.util.Scanner;

public class lb2 {

    public static void start(Scanner scanner) {

        System.out.println("Enter the dimensions of the matrix (rows and columns):");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }


        int count = 0;
        for (int i = 0; i < rows; i++) {
            boolean hasNegative = false;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < 0) {
                    hasNegative = true;
                    break;
                }
            }
            if (!hasNegative) {
                count++;
            }
        }

        System.out.println("Number of rows without negative numbers: " + count);
    }
}
