package preparation.binarytrees;

public class GivenBinaryTreeIsBinarySearchTree {
    /**
     * Given a binary tree is binary search tree or not.
     * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
     */

    private static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isBSTUtil(Node root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.val < min && root.val > max) {
            return false;
        }
        return isBSTUtil(root.left, min, root.val -1)
                && isBSTUtil(root.right, root.val+1, max);

    }

    public static boolean isBST(Node root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isBSTUtil(root, min, max);
    }

    private static Node prev = null;
    public static boolean isBSTInorder(Node root) {
        if(root != null) {
            if(!isBSTInorder(root.left)) {
                return false;
            }
            if(prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            if(!isBSTInorder(root.right)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBSTInorderWithoutStaticUtil(Node root, Node prev) {
        if(root != null) {
            if(!isBSTInorder(root.left)) {
                return false;
            }
            if(prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            if(!isBSTInorder(root.right)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isBSTInorderWithoutStatic(Node root) {
        return isBSTInorderWithoutStaticUtil(root, null);
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (isBSTInorderWithoutStatic(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
