import java.util.Scanner;

public class lb3 {

    public static void start(Scanner scanner) {
        System.out.print("Enter the number of applicants: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        ABITURIENT[] applicants = new ABITURIENT[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter specialty: ");
            String specialty = scanner.nextLine();
            int[] scores = new int[3];
            System.out.println("Enter exam scores (3 subjects): ");
            for (int j = 0; j < 3; j++) {
                scores[j] = scanner.nextInt();
            }
            scanner.nextLine();
            applicants[i] = new ABITURIENT(name, specialty, scores);
        }

        System.out.print("Enter passing score: ");
        int passingScore = scanner.nextInt();
        System.out.println("Applicants with scores below passing score:");
        for (ABITURIENT applicant : applicants) {
            int avgScore = (applicant.scores[0] + applicant.scores[1] + applicant.scores[2]) / 3;
            if (avgScore < passingScore) {
                System.out.println("Name: " + applicant.name + ", Specialty: " + applicant.specialty);
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
