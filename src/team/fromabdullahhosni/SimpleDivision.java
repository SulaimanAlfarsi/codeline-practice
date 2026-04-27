/**
 * SimpleDivision - Demonstrates integer division.
 * 
 * This class shows how to divide two integers and store the quotient.
 * Note: Integer division truncates any decimal portion.
 */
public class SimpleDivision {
    /**
     * Main method that performs integer division.
     * Divides total (100) by parts (5) to get the quotient.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int total;
        int parts;
        int quotient;
        total = 100;
        parts = 5;
        quotient = total / parts;
        System.out.println(quotient);
    }
}