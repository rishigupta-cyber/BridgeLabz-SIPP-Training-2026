public class LogStreamMerge {

    static class Node {
        int timestamp;
        Node next;

        Node(int timestamp) {
            this.timestamp = timestamp;
        }
    }

    static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.timestamp <= b.timestamp) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;

        return dummy.next;
    }

    static void printStream(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.timestamp);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(4);
        a.next.next = new Node(6);

        Node b = new Node(2);
        b.next = new Node(3);
        b.next.next = new Node(8);
        b.next.next.next = new Node(9);

        System.out.println("Stream A:");
        printStream(a);
        System.out.println("Stream B:");
        printStream(b);

        Node merged = mergeLogStreams(a, b);

        System.out.println("Merged, time-ordered stream:");
        printStream(merged);
    }
}