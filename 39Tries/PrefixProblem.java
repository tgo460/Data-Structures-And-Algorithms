public class PrefixProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            // ...existing code...
            freq = 1;
        }
    }

    static Node root = new Node();

    static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    static void findPrefix(Node node, String ans) {
        if (node == null) return;

        if (node.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                findPrefix(node.children[i], ans + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        root.freq = -1; // avoid printing empty prefix
        findPrefix(root, "");
    }
}