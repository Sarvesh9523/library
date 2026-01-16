import java.io.Serializable;

public class Member implements Serializable {
    private String memberId;
    private String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return memberId + "," + name;
    }

    public static Member fromString(String data) {
        String[] arr = data.split(",");
        return new Member(arr[0], arr[1]);
    }
}
