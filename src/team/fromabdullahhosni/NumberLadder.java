/**
 * NumberLadder - Prints a climbing pattern of numbers.
 * 
 * This class demonstrates the use of tab escape characters (\t)
 * to create a ladder-like number pattern from 1 to 5.
 */
public class NumberLadder {
    /**
     * Main method that prints a number ladder from 1 to 5.
     * Uses tab escape characters (\t) to separate numbers on the same line.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("1");
        System.out.println("1\t2");
        System.out.println("1\t2\t3");
        System.out.println("1\t2\t3\t4");
        System.out.println("1\t2\t3\t4\t5");
    }
}