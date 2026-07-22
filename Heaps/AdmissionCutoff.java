import java.util.PriorityQueue;
import java.util.Scanner;

public class AdmissionCutoff {

    static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {88, 95, 72, 60, 99, 85, 91, 78, 83, 67};

        System.out.print("Enter k (rank cutoff): ");
        int k = sc.nextInt();

        int cutoff = findKthLargest(scores, k);
        System.out.println("The " + k + "-th largest score (admission cutoff) is: " + cutoff);
    }
}