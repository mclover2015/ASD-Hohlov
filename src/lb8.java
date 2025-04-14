import java.util.*;

public class lb8 {


    // Лінійний пошук
    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // лінійний пошук з бар'єром
    static int linearSearchWithBarrier(int[] arr, int key) {
        int[] temp = Arrays.copyOf(arr, arr.length + 1);
        temp[temp.length - 1] = key;

        int i = 0;
        while (temp[i] != key) i++;

        return (i == arr.length) ? -1 : i;
    }

    // Бінарний пошук
    static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Фібоначчі
    static int fibonacciSearch(int[] arr, int key) {
        int n = arr.length;
        int fibMm2 = 0;
        int fibMm1 = 1;
        int fibM = fibMm2 + fibMm1;

        while (fibM < n) {
            fibMm2 = fibMm1;
            fibMm1 = fibM;
            fibM = fibMm2 + fibMm1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMm2, n - 1);

            if (arr[i] < key) {
                fibM = fibMm1;
                fibMm1 = fibMm2;
                fibMm2 = fibM - fibMm1;
                offset = i;
            } else if (arr[i] > key) {
                fibM = fibMm2;
                fibMm1 = fibMm1 - fibMm2;
                fibMm2 = fibM - fibMm1;
            } else {
                return i;
            }
        }

        if (fibMm1 == 1 && offset + 1 < n && arr[offset + 1] == key)
            return offset + 1;

        return -1;
    }

    // пошук з перестановкою в початок
    static int moveToFrontSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (i != 0) {
                    int temp = arr[i];
                    arr[i] = arr[0];
                    arr[0] = temp;
                }
                return i;
            }
        }
        return -1;
    }

    // транспозиція
    static int transpositionSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (i > 0) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    return i - 1;
                }
                return i;
            }
        }
        return -1;
    }


    static List<Integer> findSymmetricDifference(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int a : A) setA.add(a);
        for (int b : B) setB.add(b);

        Set<Integer> result = new HashSet<>(setA);
        result.addAll(setB);

        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        result.removeAll(intersection);
        return new ArrayList<>(result);
    }


    public static void start(Scanner scanner) {
        System.out.println("=== Лабораторна 3 ===");

        int[] A = {3, 7, 9, 12, 5, 4};
        int[] B = {1, 4, 8, 9, 10};

        System.out.println("Масив A: " + Arrays.toString(A));
        System.out.println("Масив B: " + Arrays.toString(B));

        List<Integer> symDiff = findSymmetricDifference(A, B);
        System.out.println("Симетрична різниця: " + symDiff);


        System.out.println("\n=== Пошук елементів у масиві A ===");

        for (int val : symDiff) {
            System.out.println("\nШукаємо " + val + ":");

            int res1 = linearSearch(A, val);
            int res2 = linearSearchWithBarrier(A, val);

            int[] sortedA = A.clone();
            Arrays.sort(sortedA);
            int res3 = binarySearch(sortedA, val);
            int res4 = fibonacciSearch(sortedA, val);

            int[] tempA1 = A.clone();
            int[] tempA2 = A.clone();

            int res5 = moveToFrontSearch(tempA1, val);
            int res6 = transpositionSearch(tempA2, val);

            System.out.println("Лінійний пошук: " + res1);
            System.out.println("Лін. пошук з бар'єром: " + res2);
            System.out.println("Бінарний пошук: " + res3 + " (в сортованому)");
            System.out.println("Фібоначчі пошук: " + res4 + " (в сортованому)");
            System.out.println("Пошук з перестановкою: " + res5);
            System.out.println("Пошук з транспозицією: " + res6);
        }


        System.out.println("\n=== Сортування симетричної різниці ===");
        Collections.sort(symDiff);
        System.out.println("Відсортовано: " + symDiff);
    }
}
