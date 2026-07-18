import java.util.HashSet;
import java.util.Set;

public class DuplicateSessionToken {
    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens1 = {"abc123", "xyz789", "def456", "abc123"};
        String[] tokens2 = {"abc123", "xyz789", "def456"};

        System.out.println("tokens1 has duplicate: " + hasDuplicateToken(tokens1));
        System.out.println("tokens2 has duplicate: " + hasDuplicateToken(tokens2));
    }
}