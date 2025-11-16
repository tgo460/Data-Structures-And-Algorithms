import java.util.*;

public class LowestCommonAncestor {
    // Binary Tree Definition
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // public class Binary

    public static void KLevel(Node root, int level, int k) {
        if(root == null) return;

        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, level + 1, k);
        KLevel(root.right, level + 1, k);


    }
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        // last common ancestor
        int i = 0;
        // for(; i < path1.size() && i < path2.size(); i++) {
        //     if(path1.get(i) != path2.get(i)) {
        //         break;
        //     }
        // }

        while(i < path1.size() && i < path2.size() && path1.get(i).data == path2.get(i).data) {
            i++;
        }

        // last equal node -> i - 1th
        return path1.get(i - 1);

    }

    // Lowest Common Ancestor (LCA)

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) return false;
        path.add(root);

        if(root.data == n) return true;
        if (getPath(root.left, n, path) || getPath(root.right, n, path)) return true;
        path.remove(path.size() - 1);
        return false;

        // boolean foundLeft = getPath(root.left, n, path);
        // boolean foundRight = getPath(root.right, n, path);

        //     if(foundLeft || foundRight) {
        //         return true;
        //     }

        //     path.remove(path.size() - 1);
    }


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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // int k = 3;
        // KLevel(root, 1, k);

        int n1 = 2, n2 = 3;
        Node ancestor = lca(root, n1, n2);
        System.out.println(ancestor.data);

    }
}