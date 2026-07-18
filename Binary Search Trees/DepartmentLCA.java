public class DepartmentLCA {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public static Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root;
        while (current != null) {
            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = null;
        int[] departments = {50, 30, 70, 20, 40, 60, 80};
        for (int dept : departments) {
            root = insert(root, dept);
        }

        Node lca = lowestCommonAncestor(root, 20, 40);
        System.out.println("LCA of 20 and 40: " + lca.val);
    }
}