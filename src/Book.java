package src;
import java.io.Serializable;

public class Book implements Serializable {
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

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return isbn + "," + title + "," + author + "," + isIssued;
    }

    public static Book fromString(String data) {
        String[] arr = data.split(",");
        Book book = new Book(arr[0], arr[1], arr[2]);
        book.setIssued(Boolean.parseBoolean(arr[3]));
        return book;
    }
}
