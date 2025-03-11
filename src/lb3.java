import java.util.Scanner;

class ABITURIENT {
    String name;
    String gender;
    String spec;
    int[] examResults = new int[3]; // Array to store exam results for 3 subjects

    // Constructor to initialize the ABITURIENT object
    ABITURIENT(String name, String gender, String spec, int[] examResults) {
        this.name = name;
        this.gender = gender;
        this.spec = spec;
        this.examResults = examResults;
    }

    // Calculate the average score of the entrant
    double getAverageScore() {
        int sum = 0;
        for (int score : examResults) {
            sum += score;
        }
        return sum / 3.0;
    }

    // Print the name and specialty
    void print() {
        System.out.println("Name: " + name + ", Specialty: " + spec);
    }
}

public class lb3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Enter the number of students
        System.out.print("Enter the number of applicants: ");
        int N = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        // Step 2: Create an array of ABITURIENT objects
        ABITURIENT[] ABITUR = new ABITURIENT[N];

        // Step 3: Input data for each ABITURIENT
        for (int i = 0; i < N; i++) {
            System.out.println("Enter data for applicant #" + (i + 1));

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter specialty: ");
            String spec = scanner.nextLine();

            int[] examResults = new int[3];
            System.out.print("Enter exam results for 3 subjects (space-separated): ");
            for (int j = 0; j < 3; j++) {
                examResults[j] = scanner.nextInt();
            }
            scanner.nextLine();  // Consume the newline

            ABITUR[i] = new ABITURIENT(name, gender, spec, examResults);
        }

        // Step 4: Sort applicants by average score
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (ABITUR[i].getAverageScore() > ABITUR[j].getAverageScore()) {
                    ABITURIENT temp = ABITUR[i];
                    ABITUR[i] = ABITUR[j];
                    ABITUR[j] = temp;
                }
            }
        }

        // Step 5: Ask for the passing score
        System.out.print("Enter the passing score: ");
        double passingScore = scanner.nextDouble();

        // Step 6: Display applicants with scores below the passing score
        boolean found = false;
        System.out.println("\nApplicants with scores below the passing score:");
        for (ABITURIENT abit : ABITUR) {
            if (abit.getAverageScore() < passingScore) {
                abit.print();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No applicants have scores below the passing score.");
        }

        scanner.close();
    }
}
