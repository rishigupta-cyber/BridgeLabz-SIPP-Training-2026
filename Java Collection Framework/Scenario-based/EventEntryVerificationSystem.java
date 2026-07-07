import java.util.HashSet;

public class EventEntryVerificationSystem {
    static HashSet<String> registeredEmails = new HashSet<>();

    static void registerParticipant(String email) {
        if (registeredEmails.contains(email)) {
            System.out.println(email + " - Registration rejected, already registered");
        } else {
            registeredEmails.add(email);
            System.out.println(email + " - Registration successful");
        }
    }

    static void displayRegisteredParticipants() {
        System.out.println("--- Registered Participants ---");
        for (String email : registeredEmails) {
            System.out.println(email);
        }
        System.out.println("Total attendees eligible: " + registeredEmails.size());
    }

    public static void main(String[] args) {
        registerParticipant("rohit.sharma@email.com");
        registerParticipant("neha.kulkarni@email.com");
        registerParticipant("vikram.singh@email.com");
        registerParticipant("rohit.sharma@email.com");
        registerParticipant("anita.desai@email.com");

        System.out.println();
        displayRegisteredParticipants();
    }
}