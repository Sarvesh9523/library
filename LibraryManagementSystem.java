import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Book Class
class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: \"" + title + "\", Author: " + author + ", Status: " + (isIssued ? "Issued" : "Available");
    }
}

// Member Class
class Member {
    private String memberId;
    private String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}

// Library Class
class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (findBookByIsbn(book.getIsbn()) != null) {
            System.out.println("ERROR: A book with ISBN \"" + book.getIsbn() + "\" already exists.");
            return;
        }
        books.add(book);
        System.out.println("SUCCESS: Book \"" + book.getTitle() + "\" added.");
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("INFO: No books in the library.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("-----------------");
    }

    public void listAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("INFO: No books in the library.");
            return;
        }
        System.out.println("\n--- Available Books ---");
        boolean found = false;
        for (Book book : books) {
            if (!book.isIssued()) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("INFO: No books are currently available.");
        }
        System.out.println("-----------------------");
    }

    public void addMember(Member member) {
        if (findMemberById(member.getMemberId()) != null) {
            System.out.println("ERROR: A member with ID \"" + member.getMemberId() + "\" already exists.");
            return;
        }
        members.add(member);
        System.out.println("SUCCESS: Member \"" + member.getName() + "\" added.");
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void issueBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("ERROR: Book with ISBN " + isbn + " not found.");
            return;
        }

        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("ERROR: Member with ID " + memberId + " not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("ERROR: Book \"" + book.getTitle() + "\" is already issued.");
        } else {
            book.setIssued(true);
            System.out.println("SUCCESS: Book \"" + book.getTitle() + "\" has been issued to " + member.getName() + ".");
        }
    }

    public void returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("ERROR: Book with ISBN " + isbn + " not found.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("ERROR: Book \"" + book.getTitle() + "\" is not currently issued.");
        } else {
            book.setIssued(false);
            System.out.println("SUCCESS: Book \"" + book.getTitle() + "\" has been returned.");
        }
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Pre-populated data
        library.addBook(new Book("978-0321765723", "The C++ Programming Language", "Bjarne Stroustrup"));
        library.addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin"));
        library.addMember(new Member("M001", "Sarvesh Kumar"));
        library.addMember(new Member("M002", "Jane Doe"));

        System.out.println("\nWelcome to the Library Management System!");

        while (true) {
            printMenu();
            int choice = -1;
            try {
                System.out.print("\nEnter your choice: ");
                choice = scanner.nextInt(); 
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input. Please enter a number.");
                scanner.next(); // Clear buffer
                continue;
            }
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(isbn, title, author));
                    break;
                case 2:
                    library.listAvailableBooks();
                    break;
                case 3:
                    library.listAllBooks();
                    break;
                case 4:
                    System.out.print("Enter ISBN of the book to issue: ");
                    String issueIsbn = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    library.issueBook(issueIsbn, memberId);
                    break;
                case 5:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;
                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    return;
                case 7:
                    System.out.print("Enter Member ID: ");
                    String newMemberId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String newName = scanner.nextLine();
                    library.addMember(new Member(newMemberId, newName));
                    break;
                default:
                    System.out.println("ERROR: Invalid choice. Please select a valid option (1-7).");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n========== Library Menu ==========");
        System.out.println("1. Add a new Book");
        System.out.println("2. List all available Books");
        System.out.println("3. List all Books (including issued)");
        System.out.println("4. Issue a Book");
        System.out.println("5. Return a Book");
        System.out.println("6. Exit");
        System.out.println("7. Add a new Member");
        System.out.println("==================================");
    }
}
