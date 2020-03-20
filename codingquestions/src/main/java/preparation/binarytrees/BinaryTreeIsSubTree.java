package preparation.binarytrees;

public class BinaryTreeIsSubTree {
    /**
     * Given two binary trees t1 and t2 , check if t2 is sub tree of t1
     * complexity is O(mn)
     *
     * O(n) solution is
     * for both binary trees, get inorder and pre (or post) order list as array
     * compare in[t1] with in[t2] and pre[t1] and pre[t2] // as sub list
     *
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
    private static Node root1, root2;

    private static boolean areTreesIdentical(Node t1, Node t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return ((t1.val == t2.val)
                && areTreesIdentical(t1.left, t2.left)
                && areTreesIdentical(t1.right, t2.right));
    }

    public static boolean isSubtree(Node t1, Node t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        if(areTreesIdentical(t1, t2)) {
            return true;
        }
        return ((isSubtree(t1.left, t2)) || isSubtree(t1.right, t2));
    }

    public static void main(String[] args) {
        BinaryTreeIsSubTree tree = new BinaryTreeIsSubTree();

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6); // sub tree true val is 6
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);

        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }
}
