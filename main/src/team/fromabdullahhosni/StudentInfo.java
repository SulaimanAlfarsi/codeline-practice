package team.fromabdullahhosni;

/**
 * StudentInfo - Displays student information in a table format.
 * 
 * This class demonstrates using tab (\t) and newline (\n) escape
 * characters to format tabular data in a single print statement.
 */
public class StudentInfo {
    /**
     * Main method that prints student data table.
     * Uses \t for column separation and \n for row breaks.
     * Displays Name, Age, and Grade for two students.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Name\tAge\tGrade\nJohn\t20\tA\nSarah\t22\tB");
    }
}