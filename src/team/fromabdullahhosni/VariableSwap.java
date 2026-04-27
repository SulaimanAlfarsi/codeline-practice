/**
 * VariableSwap - Demonstrates swapping values between two variables.
 * 
 * This class shows how to swap the values of two integers using
 * a temporary variable. This is a common programming pattern.
 */
public class VariableSwap {
    /**
     * Main method that demonstrates value swapping.
     * Uses a temporary variable to swap values between a and b.
     * Shows the values before and after the swap operation.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int a;
        int b;
        int temp;
        
        // Initialize the variables
        a = 10;
        b = 20;
        
        // Display values before swap
        System.out.println("Before swap: a = " + a + ", b = " + b);
        
        // Swap process using temporary variable
        temp = a;  // Store original value of a in temp
        a = b;     // Assign b's value to a
        b = temp;  // Assign temp's (original a's) value to b
        
        // Display values after swap
        System.out.println("After swap: a = " + a + ", b = " + b);
    }
}