

import java.util.*;

public class LibraryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        seedDemoData();
        System.out.println("Welcome to Simple Library Management System");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Choose option: ");
            switch (choice) {
                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> listAllBooks();
                case 6 -> listAllMembers();
                case 7 -> listBorrowedBooks();
                case 8 -> searchBooksByTitle();
                case 9 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
    }

    private static void showMenu() {
        System.out.println("""
                1. Add Book
                2. Add Member
                3. Borrow Book
                4. Return Book
                5. List All Books
                6. List All Members
                7. List Borrowed Books
                8. Search Books by Title
                9. Exit
                """);
    }

    private static void addBook() {
        System.out.println("Add Book");
        String title = readLine("Title: ");
        String author = readLine("Author: ");
        int copies = readInt("Number of copies: ");
        Book b = library.addBook(title, author, copies);
        System.out.println("Added: " + b);
    }

    private static void addMember() {
        System.out.println("Add Member");
        String name = readLine("Member name: ");
        String email = readLine("Email: ");
        Member m = library.addMember(name, email);
        System.out.println("Added member: " + m);
    }

    private static void borrowBook() {
        System.out.println("Borrow Book");
        int memberId = readInt("Member ID: ");
        int bookId = readInt("Book ID: ");
        int days = readInt("Borrow duration (days): ");
        try {
            BorrowRecord rec = library.borrowBook(memberId, bookId, days);
            System.out.println("Borrow successful: " + rec);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.println("Return Book");
        int memberId = readInt("Member ID: ");
        int bookId = readInt("Book ID: ");
        try {
            library.returnBook(memberId, bookId);
            System.out.println("Book returned successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listAllBooks() {
        System.out.println("All Books");
        library.getAllBooks().forEach(System.out::println);
    }

    private static void listAllMembers() {
        System.out.println("All Members");
        library.getAllMembers().forEach(System.out::println);
    }

    private static void listBorrowedBooks() {
        System.out.println("Borrowed Records");
        library.getAllBorrowRecords().forEach(System.out::println);
    }

    private static void searchBooksByTitle() {
        String q = readLine("Search title contains: ");
        library.searchBooksByTitle(q).forEach(System.out::println);
    }

    // Input helpers
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void seedDemoData() {
        library.addBook("Introduction to Java", "Herbert Schildt", 3);
        library.addBook("Algorithms", "S. Dasgupta", 2);
        library.addBook("Clean Code", "Robert C. Martin", 1);
        library.addMember("Alice", "alice@example.com");
        library.addMember("Bob", "bob@example.com");
    }
}
