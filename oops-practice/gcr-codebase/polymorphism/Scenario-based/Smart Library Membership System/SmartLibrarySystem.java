public class SmartLibrarySystem {

    static void printAllMembers(LibraryMember[] members) {
        System.out.println("--- All Members ---");
        for (LibraryMember member : members) {
            member.displayDetails();
        }
    }

    static LibraryMember findMemberById(LibraryMember[] members, String searchId) {
        for (LibraryMember member : members) {
            if (member.memberId.equals(searchId)) {
                return member;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryMember[] members = new LibraryMember[4];
        members[0] = new StudentMember("Rohit Sharma", "LIB101");
        members[1] = new FacultyMember("Dr. Meena Shah", "LIB102");
        members[2] = new GuestMember("Suresh Patil", "LIB103");
        members[3] = new StudentMember("Neha Kulkarni", "LIB104");

        printAllMembers(members);

        System.out.println("\n--- Fine Calculation (10 overdue days) ---");
        for (LibraryMember member : members) {
            double fine = member.calculateFine(10);
            System.out.println(member.memberName + " (ID: " + member.memberId + ") - Fine: Rs." + fine);
        }

        System.out.println("\n--- Search Member by ID ---");
        String searchId = "LIB103";
        LibraryMember found = findMemberById(members, searchId);

        if (found != null) {
            System.out.println("Member found:");
            found.displayDetails();
        } else {
            System.out.println("No member found with ID: " + searchId);
        }
    }
}