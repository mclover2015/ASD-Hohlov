import java.util.Scanner;

public class lb3 {

    public static void start(Scanner scanner) {
        System.out.print("enter the number of applicants: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        ABITURIENT[] applicants = new ABITURIENT[n];

        for (int i = 0; i < n; i++) {
            System.out.println("enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter specialty: ");
            String specialty = scanner.nextLine();
            int[] scores = new int[3];
            System.out.println("enter exam scores (3 subjects): ");
            for (int j = 0; j < 3; j++) {
                scores[j] = scanner.nextInt();
            }
            scanner.nextLine();
            applicants[i] = new ABITURIENT(name, specialty, scores);
        }

        System.out.print("enter passing score: ");
        int passingScore = scanner.nextInt();
        System.out.println("applicants with scores below passing score:");
        for (ABITURIENT applicant : applicants) {
            int avgScore = (applicant.scores[0] + applicant.scores[1] + applicant.scores[2]) / 3;
            if (avgScore < passingScore) {
                System.out.println("name: " + applicant.name + ", specialty: " + applicant.specialty);
            }
        }
    }


    static class ABITURIENT {
        String name;
        String specialty;
        int[] scores;

        public ABITURIENT(String name, String specialty, int[] scores) {
            this.name = name;
            this.specialty = specialty;
            this.scores = scores;
        }
    }
}
