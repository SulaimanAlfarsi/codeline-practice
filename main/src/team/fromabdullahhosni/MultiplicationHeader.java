package team.fromabdullahhosni;

/**
 * MultiplicationHeader - Displays a formatted multiplication table header.
 * 
 * This class prints the header portion of a multiplication table,
 * demonstrating the use of tab escape characters (\t) for alignment.
 */
public class MultiplicationHeader {
    /**
     * Main method that prints the multiplication table header.
     * Uses tab escape characters (\t) to align numbers 1-10.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("           MULTIPLICATION TABLE");
        System.out.println("=========================================");
        System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
        System.out.println("-----------------------------------------");
    }
}