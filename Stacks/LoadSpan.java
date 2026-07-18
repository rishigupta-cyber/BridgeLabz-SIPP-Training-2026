import java.util.ArrayDeque;
import java.util.Deque;

public class LoadSpan {
    public static int[] loadSpan(int[] load) {
        int n = load.length;
        int[] span = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] load = {40, 55, 30, 60, 65, 20, 70};
        int[] span = loadSpan(load);

        for (int i = 0; i < load.length; i++) {
            System.out.println("Reading " + i + " (" + load[i] + ") -> span: " + span[i]);
        }
    }
}