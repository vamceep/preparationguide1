package preparation.binarytrees;

public class IsBalancedBinaryTree {
    /**
     * Check if the given tree is balanced binary tree or not.
     * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
     *
     * Method 1: O(n^2) : recursively check the height and check if it balanced.
     * Method 2: O(n): While doing recursion, calculate height and check if it is
     * balanced.
     */

    public static class Node {

        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static Node root = null;

    public static int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    public static boolean isBalancedMethod1(Node root) {
        if(root == null) {
            return true;
        }
        int left_h = getHeight(root.left);
        int right_h = getHeight(root.right);
        if(Math.abs((left_h - right_h)) <=1
                && isBalancedMethod1(root.left)
                && isBalancedMethod1(root.right)) {
            return true;
        }
        return false;
    }

    // can use recursive calls
    static class Height {
        int height = 0;
    }
    public static boolean isBalancedMethod2Util(Node root, Height height) {
        if(root == null) {
            height.height = 0;
            return true;
        }
        Height leftHeight = new Height();
        Height rightHight = new Height();

        boolean leftBalanced = isBalancedMethod2Util(root.left, leftHeight);
        boolean rightBalanced = isBalancedMethod2Util(root.right, rightHight);
        height.height = Math.max(leftHeight.height, rightHight.height) + 1;
        if(Math.abs(leftHeight.height - rightHight.height) >= 2) {
            return false;
        }
        return leftBalanced && rightBalanced;
    }
    public static boolean isBalancedMethod2(Node root) {
        Height height = new Height();
        return isBalancedMethod2Util(root, height);
    }
    public static void main(String args[])
    {
        IsBalancedBinaryTree tree = new IsBalancedBinaryTree();
        // non balace example:
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        // balanced example:
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//        tree.root.right.right = new Node(6);
//        tree.root.left.left.left = new Node(7);

        if (tree.isBalancedMethod2(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
