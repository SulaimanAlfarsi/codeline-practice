package team.fromsulaiman;

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
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void showAvailableBooks() {
        boolean found = false;
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                book.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books.");
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

    public int getBookCount() {
        return books.size();
    }

    public int getAvailableCount() {
        int count = 0;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                count++;
            }
        }
        return count;
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("All Books:");
        for (Book book : books) {
            book.displayInfo();
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                System.out.println("Book removed.");
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public void clear() {
        books.clear();
        System.out.println("Library cleared.");
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public boolean hasBook(String title) {
        return findBook(title) != null;
    }

    public void listBorrowedBooks() {
        boolean found = false;
        System.out.println("Borrowed Books:");
        for (Book book : books) {
            if (book.isBorrowed()) {
                book.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books currently borrowed.");
        }
    }
}