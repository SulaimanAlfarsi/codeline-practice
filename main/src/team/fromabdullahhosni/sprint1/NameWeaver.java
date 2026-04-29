package team.fromabdullahhosni.sprint1;

/**
 * NameWeaver - Demonstrates string concatenation.
 * 
 * This class shows how to combine two strings using the + operator
 * to create a full name with a space between the first and last name.
 */
public class NameWeaver {
    /**
     * Main method that concatenates first and last name.
     * Uses the + operator to join firstName, a space, and lastName.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String firstName;
        String lastName;
        String fullName;
        firstName = "John";
        lastName = "Doe";
        fullName = firstName + " " + lastName;
        System.out.println(fullName);
    }
}
