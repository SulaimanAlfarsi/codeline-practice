package library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
    }

    public void showAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                book.displayInfo();
            }
        }
    }

    public boolean borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    System.out.println("Book is already borrowed.");
                    return false;
                }
                book.borrowBook();
                System.out.println("Book borrowed successfully.");
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    System.out.println("Book was not borrowed.");
                    return false;
                }
                book.returnBook();
                System.out.println("Book returned successfully.");
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }
}