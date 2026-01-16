package src;
import java.io.*;
import java.util.HashMap;

public class FileHandler {

    private static final String BOOK_FILE = "books.txt";
    private static final String MEMBER_FILE = "members.txt";

    public static void saveBooks(HashMap<String, Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books.values()) {
                bw.write(book.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books");
        }
    }

    public static HashMap<String, Book> loadBooks() {
        HashMap<String, Book> books = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Book book = Book.fromString(line);
                books.put(book.getIsbn(), book);
            }
        } catch (IOException ignored) {}
        return books;
    }

    public static void saveMembers(HashMap<String, Member> members) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(MEMBER_FILE))) {
            for (Member m : members.values()) {
                bw.write(m.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving members");
        }
    }

    public static HashMap<String, Member> loadMembers() {
        HashMap<String, Member> members = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MEMBER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Member m = Member.fromString(line);
                members.put(m.getMemberId(), m);
            }
        } catch (IOException ignored) {}
        return members;
    }
}
