public class RelayChainMidpoint {

    static class Node {
        String serverName;
        Node next;

        Node(String serverName) {
            this.serverName = serverName;
        }
    }

    static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node("server-A");
        head.next = new Node("server-B");
        head.next.next = new Node("server-C");
        head.next.next.next = new Node("server-D");
        head.next.next.next.next = new Node("server-E");

        Node middle = findMiddleServer(head);
        System.out.println("Middle server for maintenance: " + middle.serverName);

        Node head2 = new Node("server-1");
        head2.next = new Node("server-2");
        head2.next.next = new Node("server-3");
        head2.next.next.next = new Node("server-4");

        Node middle2 = findMiddleServer(head2);
        System.out.println("Middle server (even length chain): " + middle2.serverName);
    }
}