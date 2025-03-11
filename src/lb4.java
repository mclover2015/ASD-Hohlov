//import java.util.Scanner;
//
//public class lb4 {
//
//    public static void start(Scanner scanner) {
//        System.out.print("enter number of people: ");
//        int n = scanner.nextInt();
//        System.out.print("enter step size: ");
//        int k = scanner.nextInt();
//        System.out.println("last remaining person is at position: " + josephus(n, k));
//    }
//
//
//    private static int josephus(int n, int k) {
//        if (n == 1) return 0;
//        return (josephus(n - 1, k) + k) % n;
//
//
//
//    }
//}

import java.util.LinkedList;
import java.util.Scanner;

public class lb4 {


    public static void start(Scanner scanner) {

        System.out.println("Josephus ");
        startJosephus(scanner);


        System.out.println("\nsplit players");
        startSplitPlayers();
    }


    private static void startJosephus(Scanner scanner) {
        System.out.print("enter number of people: ");
        int n = scanner.nextInt();
        System.out.print("enter step size: ");
        int k = scanner.nextInt();
        System.out.println("last remaining person is: " + josephus(n, k));
    }

    private static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (josephus(n - 1, k) + k) % n;
    }


    private static void startSplitPlayers() {

        LinkedList<String> players = new LinkedList<>();


        for (int i = 1; i <= 20; i++) {
            players.add("player" + i);
        }


        LinkedList<String> group1 = new LinkedList<>();
        LinkedList<String> group2 = new LinkedList<>();

        int index = 0;
        int group2Count = 0;


        while (group2Count < 10) {
            index = (index + 11) % players.size();
            group2.add(players.get(index));
            players.remove(index);
            group2Count++;
        }


        group1.addAll(players);

        System.out.println("group 1: " + group1);
        System.out.println("group 2: " + group2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        start(scanner);

        scanner.close();
    }
}




