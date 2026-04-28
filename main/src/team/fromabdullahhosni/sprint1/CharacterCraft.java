package team.fromabdullahhosni.sprint1;

/**
 * CharacterCraft - Demonstrates accessing a character at a specific index.
 * 
 * This class shows how to use the charAt() method to retrieve
 * a character from a specific position in a string.
 */
public class CharacterCraft {
    /**
     * Main method that finds character at index 4.
     * Declares a String and uses charAt(4) to extract the character.
     * Note: String indices start at 0, so index 4 is the 5th character.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String word;
        word = "Learning";
        System.out.println(word.charAt(4));
    }
}