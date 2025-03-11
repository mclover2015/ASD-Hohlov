import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Select which lab you want to start:");
            System.out.println("1. Lab 1 - Linear Algebra Tasks");
            System.out.println("2. Lab 2 - Array and Matrix Tasks");
            System.out.println("3. Lab 3 - Struct for ABITURIENT");
            System.out.println("4. Lab 4 - Josephus Problem");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nStarting Lab 1...");
                    lb1.start(scanner);
                    break;
                case 2:
                    System.out.println("\nStarting Lab 2...");
                    lb2.start(scanner);
                    break;
                case 3:
                    System.out.println("\nStarting Lab 3...");
                    lb3.start(scanner);
                    break;
                case 4:
                    System.out.println("\nStarting Lab 4...");
                    lb4.start(scanner);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

