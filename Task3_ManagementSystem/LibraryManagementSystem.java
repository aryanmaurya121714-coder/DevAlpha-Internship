import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    public static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                book.displayBook();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isIssued()) {
                    book.issueBook();
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isIssued()) {
                    book.returnBook();
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> searchBook();
                case 4 -> issueBook();
                case 5 -> returnBook();
                case 6 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}