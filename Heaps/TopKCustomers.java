import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKCustomers {

    static List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] transactions = {500, 1200, 300, 4500, 800, 2300, 150, 3700};
        int k = 3;

        List<Integer> top3 = topKLargest(transactions, k);

        System.out.println("Top " + k + " highest spending customers:");
        for (int amount : top3) System.out.println("$" + amount);
    }
}