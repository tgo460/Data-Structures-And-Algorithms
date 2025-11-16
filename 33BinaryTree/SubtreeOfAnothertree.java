// import java.util.*;

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// public class SubtreeofAnothertree {
//     public boolean isIdentical(TreeNode root, TreeNode subRoot) {
//         if(root == null & subRoot == null) {
//             return true;
//         }

//         if(root == null || subRoot || null) {
//             return false;
//         }

//         if(root.val == subRoot.val) {
//             return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
//         }

//         return false;

//     }

//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if(subRoot == null) {
//             return true;
//         }

//         if(root == null) {
//             return false;
//         }

//         if(root.val == subRoot.val) {
//             if(isIdentical(root, subRoot)) {
//                 return true;
//             }
//         }

//         return isSubtree(root.left, subRoot.val) || isSubtree(root.right, subRoot)
//     }

//     public static void main(String[] args) {

//     }
// }


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SubtreeOfAnothertree {
    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        // Sample tree:
        //      3
        //     / \
        //    4   5
        //   / \
        //  1   2
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));

        // Subtree to find:
        //   4
        //  / \
        // 1   2
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        boolean result = new SubtreeOfAnothertree().isSubtree(root, subRoot);
        System.out.println("isSubtree = " + result); // expected: true
    }
}