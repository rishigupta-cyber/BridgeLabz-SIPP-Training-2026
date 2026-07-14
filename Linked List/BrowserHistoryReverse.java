public class BrowserHistoryReverse {

    static class Node {
        String pageUrl;
        Node next;

        Node(String pageUrl) {
            this.pageUrl = pageUrl;
        }
    }

    static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void printHistory(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.pageUrl);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node("checkout.html");
        head.next = new Node("cart.html");
        head.next.next = new Node("product.html");
        head.next.next.next = new Node("home.html");

        System.out.println("History before reverse (most recent first):");
        printHistory(head);

        head = reverseHistory(head);

        System.out.println("History after reverse (oldest first):");
        printHistory(head);
    }
}