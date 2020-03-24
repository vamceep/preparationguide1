package preparation.binarytrees;

public class DepthOrHeightOfBinaryTree {
    /**
     * Given a binary / binary search tree, find the depth or height of it
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
    private static Node root;

    public static int depth(Node root) {
        if(root == null) {
            return 0;
        }
        int left_h = depth(root.left);
        int right_h = depth(root.right);
        return Math.max(left_h, right_h) +1;
    }
    public static void main(String[] args) {
        DepthOrHeightOfBinaryTree tree = new DepthOrHeightOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
        System.out.println("Depth : " + depth(root));
    }
}
