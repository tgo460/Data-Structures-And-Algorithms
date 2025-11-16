import java.util.*;

public class HeightOfTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    // Count function to return the total Numbers of Nodes in the tree

    public static int count(Node root) {
        if(root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        
        return leftCount + rightCount + 1;
    }


    // Function to find the total sum of tree
    public static int sum(Node root) {
        // Base case
        if(root == null) {
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        return leftsum + rightsum + root.data;
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

    //    System.out.println(height(root));

    // Call the count Function
    // System.out.println(count(root));

    // Call the sum funtion to print the total sum

    System.out.print(sum(root));

    }
}