package preparation.binarytrees;

public class MorrisInorderTraversal {
    /**
     * Inorder Tree Traversal without recursion and without stack!
     * Using Morris Traversal, we can traverse the tree without using stack and recursion.
     * The idea of Morris Traversal is based on Threaded Binary Tree. In this traversal,
     * we first create links to Inorder successor and print the data using these links, and
     * finally revert the changes to restore original tree.
     *
     * 1. Initialize current as root
     * 2. While current is not NULL
     *    If the current does not have left child
     *       a) Print current’s data
     *       b) Go to the right, i.e., current = current->right
     *    Else
     *       a) Make current as the right child of the rightmost
     *          node in current's left subtree
     *       b) Go to this left child, i.e., current = current->left
     *  https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
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

    public static void MorrisTraversal(Node root) {
        Node current, prev;
        if(root == null) {
            return;
        }
        current = root;
        while(current != null) {
            if(current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            }else {
                prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = current;
                    current = current.left;
                }else {
                    prev.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }
    public static void main(String[] args) {
        MorrisInorderTraversal tree = new MorrisInorderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.MorrisTraversal(tree.root);
    }
}
