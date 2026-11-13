import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
    private final Map<Integer, Book> books = new HashMap<>();   // 1. Store Book ID and Book Name
    private final Set<Integer> bookIds = new HashSet<>();       // 2. Unique book IDs
    private final List<String> history = new ArrayList<>();     // 3. History of issued books

    // 4 & 9. Add book - prevents duplicate IDs
    public boolean addBook(int id, String name) {
        if (bookIds.contains(id)) {
            System.out.println("Duplicate ID " + id + " - book not added.");
            return false;
        }
        bookIds.add(id);
        books.put(id, new Book(id, name));
        System.out.println("Book added: " + id + " - " + name);
        return true;
    }

    // 4. Add 10 sample books
    public void addTenBooks() {
        String[] names = {
            "Java Basics", "Data Structures", "Algorithms", "Operating Systems",
            "Database Systems", "Computer Networks", "Python Programming",
            "Web Development", "Software Engineering", "Artificial Intelligence"
        };
        for (int i = 0; i < names.length; i++) {
            addBook(101 + i, names[i]);
        }
    }

    // 5. Issue a book to a student
    public void issueBook(int id, String student) {
        Book book = books.get(id);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued to " + book.getIssuedTo());
        } else {
            book.issueTo(student);
            history.add("ISSUED  : Book " + id + " (" + book.getName() + ") to " + student);
            System.out.println("Book issued to " + student);
        }
    }

    // 6. Return a book
    public void returnBook(int id) {
        Book book = books.get(id);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isIssued()) {
            System.out.println("This book was not issued.");
        } else {
            history.add("RETURNED: Book " + id + " (" + book.getName() + ") from " + book.getIssuedTo());
            book.markReturned();
            System.out.println("Book returned.");
        }
    }

    // 7. Display all available books
    public void displayAvailableBooks() {
        System.out.println("--- Available Books ---");
        boolean found = false;
        for (Book b : books.values()) {
            if (!b.isIssued()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No books available.");
    }

    // 8. Display issued book history
    public void displayHistory() {
        System.out.println("--- Issued Book History ---");
        if (history.isEmpty()) {
            System.out.println("No history yet.");
            return;
        }
        for (String h : history) System.out.println(h);
    }
}
