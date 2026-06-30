public class FacultyMember extends LibraryMember {
    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 0.5;
    }
}