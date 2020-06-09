package preparation.binarytrees;

public class TreeToSumTree {
    /**
     * Convert a given tree to its Sum Tree
     * Given a Binary Tree where each node has positive and negative values.
     * Convert this to a tree where each node contains the sum of the left and right sub trees
     * in the original tree. The values of leaf nodes are changed to 0.
     * For example, the following tree
     *
     *                   10
     *                /      \
     *              -2        6
     *            /   \      /  \
     *          8     -4    7    5
     *
     * should be to:
     *   20(4-2+12+6)
     *                /      \
     *          4(8-4)      12(7+5)
     *            /   \      /  \
     *          0      0    0    0
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
    public static Node root;
    void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    int toSumTree(Node root) {
        if(root == null) {
            return 0;
        }
        int olddata = root.val;
        root.val = toSumTree(root.left) + toSumTree(root.right);
        return olddata + root.val;
    }
    public static void main(String[] args) {
        TreeToSumTree tree = new TreeToSumTree();

        /* Constructing tree given in the above figure */
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);

        tree.toSumTree(tree.root);

        // Print inorder traversal of the converted tree to test result
        // of toSumTree()
        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInorder(tree.root);
    }
}
