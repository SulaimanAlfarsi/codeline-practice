public class TestRunner {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Java Basics", "John Doe"));
        library.addBook(new Book("Learn Java", "Jane Smith"));
        library.showAvailableBooks();
        library.borrowBook("Java Basics");
        library.showAvailableBooks();
        library.returnBook("Java Basics");
        library.showAvailableBooks();
    }
}