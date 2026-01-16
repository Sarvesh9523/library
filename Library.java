import java.util.HashMap;

public class Library {

    private HashMap<String, Book> books;
    private HashMap<String, Member> members;

    public Library() {
        books = FileHandler.loadBooks();
        members = FileHandler.loadMembers();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Book already exists");
            return;
        }
        books.put(book.getIsbn(), book);
        FileHandler.saveBooks(books);
        System.out.println("Book added successfully");
    }

    public void addMember(Member member) {
        if (members.containsKey(member.getMemberId())) {
            System.out.println("Member already exists");
            return;
        }
        members.put(member.getMemberId(), member);
        FileHandler.saveMembers(members);
        System.out.println("Member added successfully");
    }

    public void issueBook(String isbn, String memberId) {
        Book book = books.get(isbn);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid ISBN or Member ID");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book already issued");
            return;
        }

        book.setIssued(true);
        FileHandler.saveBooks(books);
        System.out.println("Book issued to " + member.getName());
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);

        if (book == null || !book.isIssued()) {
            System.out.println("Invalid return");
            return;
        }

        book.setIssued(false);
        FileHandler.saveBooks(books);
        System.out.println("Book returned successfully");
    }

    public void listBooks() {
        books.values().forEach(System.out::println);
    }
}
