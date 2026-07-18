import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextBusierDay {
    public static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                answer[stack.pop()] = visitors[i];
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] visitors = {120, 90, 150, 140, 200, 80};
        int[] result = nextBusierDay(visitors);

        for (int i = 0; i < visitors.length; i++) {
            System.out.println("Day " + i + " (" + visitors[i] + " visitors) -> next busier: " + result[i]);
        }
    }
}