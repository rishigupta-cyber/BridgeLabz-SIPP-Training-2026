import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLogs {

    static class LogEntry {
        int timestamp;
        String message;

        LogEntry(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> sources.get(a[0]).get(a[1]).timestamp - sources.get(b[0]).get(b[1]).timestamp
        );

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0];
            int elemIdx = top[1];
            merged.add(sources.get(sourceIdx).get(elemIdx));
            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elemIdx + 1});
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<LogEntry> server1 = new ArrayList<>();
        server1.add(new LogEntry(1, "Server1: Boot"));
        server1.add(new LogEntry(4, "Server1: Request"));
        server1.add(new LogEntry(7, "Server1: Shutdown"));

        List<LogEntry> server2 = new ArrayList<>();
        server2.add(new LogEntry(2, "Server2: Boot"));
        server2.add(new LogEntry(5, "Server2: Error"));

        List<LogEntry> server3 = new ArrayList<>();
        server3.add(new LogEntry(3, "Server3: Boot"));
        server3.add(new LogEntry(6, "Server3: Warning"));
        server3.add(new LogEntry(8, "Server3: Shutdown"));

        List<List<LogEntry>> sources = new ArrayList<>();
        sources.add(server1);
        sources.add(server2);
        sources.add(server3);

        List<LogEntry> merged = mergeKSortedLogs(sources);

        System.out.println("Merged timeline:");
        for (LogEntry e : merged) {
            System.out.println("[" + e.timestamp + "] " + e.message);
        }
    }
}