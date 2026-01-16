package src;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Book 2.Add Member 3.Issue 4.Return 5.List 6.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(isbn, title, author));
                }
                case 2 -> {
                    System.out.print("Member ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    library.addMember(new Member(id, name));
                }
                case 3 -> {
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Member ID: ");
                    String id = sc.nextLine();
                    library.issueBook(isbn, id);
                }
                case 4 -> {
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    library.returnBook(isbn);
                }
                case 5 -> library.listBooks();
                case 6 -> {
                    System.out.println("Exit");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
