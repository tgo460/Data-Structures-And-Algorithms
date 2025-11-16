import java.util.Queue;
import java.util.LinkedList;

// File: SumOfNodesAtKthLevel.java
// Computes sum of nodes at k-th level of a binary tree.
// Convention used: root is at level 0.


public class SumOfNodesAtKthLevel {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    // Recursive solution: O(n) time, O(h) recursion space.
    public static int sumAtKLevelRecursive(Node root, int k) {
        if (root == null || k < 0) return 0;
        if (k == 0) return root.val;
        return sumAtKLevelRecursive(root.left, k - 1) + sumAtKLevelRecursive(root.right, k - 1);
    }

    // Iterative (BFS by levels): O(n) time, O(width) space.
    public static int sumAtKLevelIterative(Node root, int k) {
        if (root == null || k < 0) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k) {
                int sum = 0;
                for (Node node : q) sum += node.val; // sum nodes at desired level
                return sum;
            }
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            level++;
        }
        return 0; // k is deeper than tree height
    }

    // Example usage and simple test
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int k = 2; // change k as needed (root is level 0)
        System.out.println("Sum at level " + k + " (recursive): " + sumAtKLevelRecursive(root, k));
        System.out.println("Sum at level " + k + " (iterative): " + sumAtKLevelIterative(root, k));
    }
}