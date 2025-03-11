import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("select which lab you want to start:");
            System.out.println("1. lb1");
            System.out.println("2. lb2");
            System.out.println("3. lb3");
            System.out.println("4. lb4");
            System.out.println("0. exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n1...");
                    lb1.start(scanner);
                    break;
                case 2:
                    System.out.println("\n2...");
                    lb2.start(scanner);
                    break;
                case 3:
                    System.out.println("\n3...");
                    lb3.start(scanner);
                    break;
                case 4:
                    System.out.println("\n4...");
                    lb4.start(scanner);
                    break;
                case 0:
                    System.out.println("exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}

