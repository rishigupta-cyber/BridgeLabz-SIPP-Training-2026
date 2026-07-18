import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BalancedBrackets {
    public static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchFor = Map.of(')', '(', ']', '[', '}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != matchFor.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] configs = {
            "{ \"a\": [1, 2, 3] }",
            "{ \"a\": [1, 2, 3] }}",
            "{ \"a\": (1, 2] }",
            "[]{}()"
        };

        for (String config : configs) {
            System.out.println(config + " -> " + isValidConfig(config));
        }
    }
}