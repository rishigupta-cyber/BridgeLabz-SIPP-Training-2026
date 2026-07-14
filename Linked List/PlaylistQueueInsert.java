public class PlaylistQueueInsert {

    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
        }
    }

    static void insertAfter(Node current, int trackId) {
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }

    static void printQueue(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.trackId);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(103);

        System.out.println("Queue before insert:");
        printQueue(head);

        Node currentlyPlaying = head.next;
        insertAfter(currentlyPlaying, 999);

        System.out.println("Queue after inserting track 999 after the current track:");
        printQueue(head);
    }
}