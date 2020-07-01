package preparation.binarytrees;

public class BoundaryTraversalBinaryTree {
    /**
     * Boundary Traversal of binary tree in anti clock direction
     * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
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

    public Node root;

    public void printLeafs(Node root) {
        if (root == null) {
            return;
        }
        printLeafs(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
        }
        printLeafs(root.right);
    }

    public void printNodeLeft(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            System.out.print(root.val + " ");
            printNodeLeft(root.left);
        } else if (root.right != null) {
            System.out.print(root.val + " ");
            printNodeLeft(root.right);
        }
    }

    public void printNodeRight(Node root) {
        if (root == null) {
            return;
        }
        if(root.right != null) {
            printNodeRight(root.right);
            System.out.print(root.val + " ");
        }else if(root.left != null) {
            printNodeRight(root.left);
            System.out.print(root.val + " ");
        }
    }

    public void printBoundary(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printNodeLeft(root.left);
        printLeafs(root.left);
        printLeafs(root.right);
        printNodeRight(root.right);
    }

    public static void main(String[] args) {
        BoundaryTraversalBinaryTree tree = new BoundaryTraversalBinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
        System.out.println();
    }
}
