public class RedirectLoopDetector {

    static class Node {
        String url;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node a = new Node("siteA.com");
        Node b = new Node("siteB.com");
        Node c = new Node("siteC.com");
        Node d = new Node("siteD.com");
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Chain without loop, hasRedirectLoop = " + hasRedirectLoop(a));

        d.next = b;

        System.out.println("Chain with loop (D -> B), hasRedirectLoop = " + hasRedirectLoop(a));
    }
}