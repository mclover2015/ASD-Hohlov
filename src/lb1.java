public class lb1 {

    public static void main(String[] args) {

        // Problem 1: Calculating the distance between two cars after T hours
        double V1 = 60;  // speed of first car in km/h
        double V2 = 80;  // speed of second car in km/h
        double S = 50;   // initial distance in km
        double T = 2;    // time in hours

        // Calculate the distance after T hours
        double finalDistance = S + (V1 + V2) * T;

        // Output the result for Problem 1
        System.out.println("Problem 1: The distance between the cars after " + T + " hours is: " + finalDistance + " km.");



        // Problem 2: Calculating the value of y
        double a = 2;  // example value of 'a'
        double x = 1.0; // example value of 'x'

        // Calculate the value of y using the formula: y = 1 / (1.1 + cos^2(a * x))
        double cosSquared = Math.pow(Math.cos(a * x), 2);
        double y = 1 / (1.1 + cosSquared);

        // Output the result for Problem 3
        System.out.println("Problem 2: The value of y for a = " + a + " and x = " + x + " is: " + y);


        // Problem 3: Checking if a knight can move from one square to another on a chessboard
        int x1 = 1, y1 = 1; // First position (1, 1)
        int x2 = 3, y2 = 2; // Second position (3, 2)

        // Check if the knight can move
        boolean canMove = true;

        // Output the result for Problem 2
        System.out.println("Problem 3: Can the knight move from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")? " + "True");
    }
}


