package PracticeQuestions;

public class InvertBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int root) {
            data = root;
            left = right = null;
        }
    }

    Node root;

    void mirror() {
        root = mirror(root);
    }

    public static void main(String[] args) {

    }
}
