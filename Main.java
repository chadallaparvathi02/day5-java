import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management =====");
            System.out.println("1. Add a book");
            System.out.println("2. Add 10 sample books");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Display available books");
            System.out.println("6. Display issued book history");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Book Name: ");
                    String name = sc.nextLine();
                    library.addBook(id, name);
                    break;
                case 2:
                    library.addTenBooks();
                    break;
                case 3:
                    System.out.print("Book ID: ");
                    int issueId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Student Name: ");
                    String student = sc.nextLine();
                    library.issueBook(issueId, student);
                    break;
                case 4:
                    System.out.print("Book ID: ");
                    library.returnBook(sc.nextInt());
                    break;
                case 5:
                    library.displayAvailableBooks();
                    break;
                case 6:
                    library.displayHistory();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
