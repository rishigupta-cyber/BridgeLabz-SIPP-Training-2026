public class GuestMember extends LibraryMember {
    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 5.0;
    }
}