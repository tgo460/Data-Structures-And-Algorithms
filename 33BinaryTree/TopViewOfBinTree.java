import java.util.*;

public class TopViewOfBinTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // public static int height(Node root) {
    //     if(root == null) {
    //         return 0;
    //     }

    //     int lh = height(root.left);
    //     int rh = height(root.right);
    //     return Math.max(lh, rh) + 1;
    // }

    // // Count function to return the total Numbers of Nodes in the tree

    // public static int count(Node root) {
    //     if(root == null) {
    //         return 0;
    //     }

    //     int leftCount = count(root.left);
    //     int rightCount = count(root.right);
        
    //     return leftCount + rightCount + 1;
    // }


    // // Function to find the total sum of tree
    // public static int sum(Node root) {
    //     // Base case
    //     if(root == null) {
    //         return 0;
    //     }

    //     int leftsum = sum(root.left);
    //     int rightsum = sum(root.right);
    //     return leftsum + rightsum + root.data;
    // }
//  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // Top View Of Binary Tree 
// static class
    static class Info {
        Node node;
        int hd;
// Constructor for the info Class
        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topview(Node root) {
        if(root == null) return;
        // level order
        Queue<Info> q = new LinkedList<>();

        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null);


        while(!q.isEmpty()) {
            Info curr = q.remove();

            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)) { // first time my hd is occuring
                map.put(curr.hd, curr.node);
            }

            if(curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            if(curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* 
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

       topview(root);
    }
}