package team.fromabdullahhosni.sprint1;

/**
 * InitialImpression - Demonstrates extracting the first character from a string.
 * 
 * This class shows how to use the charAt() method to retrieve
 * the initial (first character) from a full name.
 */
public class InitialImpression {
    /**
     * Main method that extracts and prints the first character.
     * Uses charAt(0) to get the character at index 0 (the first character).
     * String indices start at 0, so charAt(0) returns the initial.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String fullName;
        fullName = "John Doe";
        System.out.println(fullName.charAt(0));
    }
}
