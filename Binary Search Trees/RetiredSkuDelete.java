import java.util.ArrayList;
import java.util.List;

public class RetiredSkuDelete {
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

    public static Node delete(Node node, int sku) {
        if (node == null) {
            return null;
        }
        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }
        return node;
    }

    private static void inorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] skus = {50, 30, 70, 20, 40, 60, 80};
        for (int sku : skus) {
            root = insert(root, sku);
        }

        root = delete(root, 20);
        root = delete(root, 30);
        root = delete(root, 50);

        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        System.out.println("Catalog after deletions: " + result);
    }
}