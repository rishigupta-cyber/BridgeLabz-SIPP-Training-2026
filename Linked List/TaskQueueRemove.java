public class TaskQueueRemove {

    static class Node {
        int taskId;
        Node next;

        Node(int taskId) {
            this.taskId = taskId;
        }
    }

    static Node removeTask(Node head, int taskId) {
        if (head == null) {
            return null;
        }

        if (head.taskId == taskId) {
            return head.next;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.taskId != taskId) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    static void printQueue(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.taskId);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Task queue before removal:");
        printQueue(head);

        head = removeTask(head, 3);

        System.out.println("Task queue after removing completed task 3:");
        printQueue(head);

        head = removeTask(head, 1);
        System.out.println("Task queue after removing task 1 (the head):");
        printQueue(head);
    }
}