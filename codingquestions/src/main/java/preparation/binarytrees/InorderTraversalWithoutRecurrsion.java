package preparation.binarytrees;

import java.util.Stack;

public class InorderTraversalWithoutRecurrsion {
    /**
     * Inorder traversal without recurssion.
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
    static Node root;

    public void inorder() {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }

    }
    public static void main(String[] args) {
        InorderTraversalWithoutRecurrsion tree = new InorderTraversalWithoutRecurrsion();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}
