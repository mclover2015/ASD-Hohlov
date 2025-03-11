public class lb2 {
    public static void main(String[] args) {
        // Example array for Task 1
        int[] arr = {3, 2, 5, 6, 7, 8, -1, 4, 3};
        int N = arr.length;

        // Task 1: Count even and odd elements, sum elements between max and min
        int evenCount = 0, oddCount = 0, sumBetweenMaxMin = 0;
        int minIndex = -1, maxIndex = -1;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        // Finding max, min and counting even/odd numbers
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if (arr[i] > maxVal) {
                maxVal = arr[i];
                maxIndex = i;
            }

            if (arr[i] < minVal) {
                minVal = arr[i];
                minIndex = i;
            }
        }

        // Ensure the max is before the min for the sum
        if (maxIndex > minIndex) {
            int temp = maxIndex;
            maxIndex = minIndex;
            minIndex = temp;
        }

        // Sum elements between max and min
        for (int i = maxIndex + 1; i < minIndex; i++) {
            sumBetweenMaxMin += arr[i];
        }

        System.out.println("Task 1:");
        System.out.println("Even count: " + evenCount);
        System.out.println("Odd count: " + oddCount);
        System.out.println("Sum between max and min: " + sumBetweenMaxMin);

        // Task 2: Find the longest decreasing subsequence
        int longestDecreasingLength = 1;
        int currentDecreasingLength = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) {
                currentDecreasingLength++;
            } else {
                longestDecreasingLength = Math.max(longestDecreasingLength, currentDecreasingLength);
                currentDecreasingLength = 1;
            }
        }

        longestDecreasingLength = Math.max(longestDecreasingLength, currentDecreasingLength);

        System.out.println("Task 2:");
        System.out.println("Longest decreasing subsequence length: " + longestDecreasingLength);

        // Example matrix for Task 3
        int[][] matrix = {
                {3, 1, -2, 4},
                {7, 2, -1, 0},
                {0, 5, 3, -4},
                {-3, -5, 2, 6}
        };

        // Task 3.1: Count rows with no negative elements
        int nonNegativeRowsCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean hasNegative = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    hasNegative = true;
                    break;
                }
            }
            if (!hasNegative) {
                nonNegativeRowsCount++;
            }
        }

        System.out.println("Task 3.1:");
        System.out.println("Number of rows without negative elements: " + nonNegativeRowsCount);

        // Task 3.2: Find the minimum number that appears more than once
        int minRepeated = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = i; k < matrix.length; k++) {
                    for (int l = (k == i ? j + 1 : 0); l < matrix[k].length; l++) {
                        if (matrix[i][j] == matrix[k][l]) {
                            if (matrix[i][j] < minRepeated) {
                                minRepeated = matrix[i][j];
                                found = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Task 3.2:");
        if (found) {
            System.out.println("Minimum number repeated more than once: " + minRepeated);
        } else {
            System.out.println("No repeated numbers found.");
        }

        // Task 4: Create an NxN matrix with zeros above the main diagonal and ones below it
        int N2 = 5; // Example size for the matrix
        int[][] squareMatrix = new int[N2][N2];

        for (int i = 0; i < N2; i++) {
            for (int j = 0; j < N2; j++) {
                if (i < j) {
                    squareMatrix[i][j] = 0;
                } else if (i > j) {
                    squareMatrix[i][j] = 1;
                } else {
                    squareMatrix[i][j] = 0; // The diagonal can be zero if not specified otherwise
                }
            }
        }

        System.out.println("Task 4:");
        System.out.println("Square matrix with 0s above the diagonal and 1s below:");
        for (int i = 0; i < N2; i++) {
            for (int j = 0; j < N2; j++) {
                System.out.print(squareMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
