package preparation.binarytrees;

public class SwapNodesEveryKLevelBinaryTree {
    /**
     *Swap Nodes in Binary tree of every k’th level
     *
     * https://www.geeksforgeeks.org/swap-nodes-binary-tree-every-kth-level/
     *
     * Input :  k = 2  and Root of below tree
     *       1             Level 1
     *     /   \
     *    2     3          Level 2
     *  /     /   \
     * 4     7     8       Level 3
     *
     * Output : Root of the following modified tree
     *       1
     *     /   \
     *    3     2
     *  /  \   /
     * 7    8  4
     * Explanation : We need to swap left and right sibling
     *               every second level. There is only one
     *               even level with nodes to be swapped are
     *               2 and 3.
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
    public static void printInOrderUtil(Node root) {
        if(root == null) {
            return;
        }
        printInOrderUtil(root.left);
        System.out.print(root.val + " ");
        printInOrderUtil(root.right);
    }
    public static void printInorder(Node root) {
        printInOrderUtil(root);
        System.out.println();
    }

    public static void swapNodesKthLevelUtil(Node root, int level, int k) {
        if(root == null || root.left == null || root.right == null) {
            return;
        }

        if((level +1) % k ==0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        // recurse for rest of tree
        swapNodesKthLevelUtil(root.left, (level+1), k);
        swapNodesKthLevelUtil(root.right, (level+1), k);
    }

    public static void swapNodesKthLevel(Node root, int k) {
        swapNodesKthLevelUtil(root, 1, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(8);
        root.right.left = new Node(7);

        int k = 2;
        System.out.println("Before swap node :");
        printInorder(root);

        swapNodesKthLevel(root, k);

        System.out.println("\nAfter swap Node :" );
        printInorder(root);
    }
}
