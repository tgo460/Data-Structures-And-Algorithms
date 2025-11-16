
// import java.util.*;

// public class DiameterOfTree {
//     static class Node {
//         int data;
//         Node left;
//         Node right;

//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     static class BinaryTree {
//         static int idx = -1;
//         public static Node buildTree(int nodes[]) {
//             idx++;
//             if(nodes[idx] == -1) {
//                 return null;
//             }

//             Node newNode = new Node(nodes[idx]);
//             newNode.left = buildTree(nodes);
//             newNode.right = buildTree(nodes);

//             return newNode;
//         }
//     }

//     public static void preOrder(Node root) {
//         if(root == null) {
//             return;
//         }

//         System.out.print(root.data + " ");
//         preOrder(root.left);
//         preOrder(root.right);
//     }

//     public static void inOrder(Node root) {
//         if(root == null) {
//             return;
//         }

//         inOrder(root.left);
//         System.out.print(root.data + " ");
//         inOrder(root.right);
//     }

//     public static void postOrder(Node root) {
//         if(root == null) {
//             return;
//         }

//         postOrder(root.left);
//         postOrder(root.right);
//         System.out.print(root.data + " ");
//     }

//     // Level Order Traversal Time Complexity is O(n) level is 2 * n O(2n) = O(n)

//     public static void levelOrder(Node root) {
//         if(root == null) {
//             return;
//         }

//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         q.add(null);

//         while(!q.isEmpty()) {
//             Node currNode = q.remove();
//             if(currNode == null) {
//                 System.out.println();
//                 if(q.isEmpty()){
//                     break;
//                 } else {
//                     q.add(null);
//                 }
//             } else {
//                 System.out.print(currNode.data + " ");
//                 if(currNode.left != null) {
//                     q.add(currNode.left);
//                 }
//                 if(currNode.right != null) {
//                     q.add(currNode.right);
//                 }
//             }
//         }
//     }

//     public static int diameter(Node root) {
//         if(root == null) {
//             return 0;
//         }
        
//         int diam1 = diameter(root.left);
//         int diam2 = diameter(root.right);
//         int diam3 = height(root.left) = height(root.right) + 1;
 
//         return Math.max(diam3, Math(diam1, diam2));
//     }

//     public static Info {
//         int diam ;
//         int ht;

//         public Info(int diam, int ht) {
//             this.diam = diam;
//             this.ht = ht;
//         }
//     }

//     public static Info diameter(Node root) {

//         if(root == null) {
//             return new Info(0, 0);
//         }
//         Info leftInfo = diameter(root.left);
//         Info rightInfo = diameter(root.right);
//         int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
//         int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

//         return new Info(diam, ht);
//     }

//     public static void main(String[] args) {
//         int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//         BinaryTree tree = new BinaryTree();
//         Node root = tree.buildTree(nodes);

//         // PreOrder Traversal
//         // preOrder(root);

//         // Inorder Traversal
//         // inOrder(root);
//         // System.out.println(root.data);

//         // Post Order
//         // postOrder(root);

//         // Level Order

//         // levelOrder(root);

//         // System.out.println(diameter(root));

//         System.out.println(diameter(root).diam);
//     }
// }


import java.util.*;

public class DiameterOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Level Order Traversal Time Complexity is O(n) level is 2 * n O(2n) = O(n)

    public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // Removed the broken int-version of diameter(Node)
    // ...existing code...

    public static class Info {
        int diam ;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {

        if(root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // PreOrder Traversal
        // preOrder(root);

        // Inorder Traversal
        // inOrder(root);
        // System.out.println(root.data);

        // Post Order
        // postOrder(root);

        // Level Order

        // levelOrder(root);

        // System.out.println(diameter(root));

        System.out.println(diameter(root).ht);
    }
}