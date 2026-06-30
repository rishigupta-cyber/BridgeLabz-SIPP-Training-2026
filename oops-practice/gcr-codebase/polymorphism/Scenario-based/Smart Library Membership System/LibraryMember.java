public class LibraryMember {
    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 1.0;
    }

    void displayDetails() {
        System.out.println("Member: " + memberName + " | ID: " + memberId);
    }
}