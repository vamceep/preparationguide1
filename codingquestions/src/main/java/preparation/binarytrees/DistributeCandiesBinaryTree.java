package preparation.binarytrees;

import static java.lang.StrictMath.abs;

public class DistributeCandiesBinaryTree {
    /**
     *Distribute candies in a Binary Tree
     * Given a binary tree with N nodes, in which each node value represents number of candies present at that node, and there are N candies in total. In one move, one may choose two adjacent nodes and move one candy from one node to another (the move may be from parent to child, or from child to parent.)
     *
     * The task is to find the number of moves required such that every node have exactly one candy.
     *
     * Examples:
     *
     *
     *
     * Input :      3
     *            /   \
     *           0     0
     * Output : 2
     * Explanation: From the root of the tree, we move one
     * candy to its left child, and one candy to
     * its right child.
     *
     * Input :      0
     *            /   \
     *           3     0
     * Output :3
     * Explanation : From the left child of the root, we move
     * two candies to the root [taking two moves]. Then, we move
     * one candy from the root of the tree to the right child.
     *
     * https://www.geeksforgeeks.org/distribute-candies-in-a-binary-tree/
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
    public static int ans = 0;
    public static int distributeCandyUtil(Node root) {
        if(root == null) {
            return 0;
        }

        int l = distributeCandyUtil(root.left);
        int r = distributeCandyUtil(root.right);
        ans += Math.abs(l) + Math.abs(r);
        return  root.val + l + r -1;

    }
    public static int distributeCandy(Node root) {
        distributeCandyUtil(root);
        return ans;
    }
    public static void main(String[] args) {
//        Node root = new Node(0);
//        root.left = new Node(3);
//        root.right = new Node(0);

//        Node root = new Node(3);
//        root.left = new Node(0);
//        root.right = new Node(0);

//        Node root = new Node(3);
//        root.left = null;
//        root.right = null;

        Node root = new Node(0);
        root.left = new Node(0);
        root.left.left = new Node(4);
        root.right = new Node(0);

        System.out.println(distributeCandy(root));
    }
}
