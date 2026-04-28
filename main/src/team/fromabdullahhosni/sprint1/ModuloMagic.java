package team.fromabdullahhosni;

/**
 * ModuloMagic - Demonstrates the modulo operator to find remainders.
 * 
 * This class shows how to use the modulo operator (%) to calculate
 * the remainder after dividing one number by another.
 */
public class ModuloMagic {
    /**
     * Main method that calculates the remainder of division.
     * Uses modulo operator (%) to find remainder of 17 divided by 3.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int num1;
        int num2;
        int remainder;
        num1 = 17;
        num2 = 3;
        remainder = num1 % num2;
        System.out.println("Remainder: " + remainder);
    }
}