public class PricingIndexValidation {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(Node node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Node validRoot = new Node(50);
        validRoot.left = new Node(30);
        validRoot.right = new Node(70);

        Node corruptRoot = new Node(50);
        corruptRoot.left = new Node(30);
        corruptRoot.right = new Node(70);
        corruptRoot.right.left = new Node(20);

        System.out.println("Valid tree check: " + isValidBST(validRoot));
        System.out.println("Corrupt tree check: " + isValidBST(corruptRoot));
    }
}