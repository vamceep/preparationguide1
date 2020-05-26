package preparation.binarytrees;

import java.util.Vector;

public class PrintAllKPathSumOfBinaryTree {
    /**
     * Print all k-sum paths in a binary tree
     * A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k.
     * A path can start from any node and end at any node and must be downward only, i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.
     *
     * Examples:
     *
     * Input : k = 5
     *         Root of below binary tree:
     *            1
     *         /     \
     *       3        -1
     *     /   \     /   \
     *    2     1   4     5
     *         /   / \     \
     *        1   1   2     6
     *
     * Output :
     * 3 2
     * 3 1 1
     * 1 3 1
     * 4 1
     * 1 -1 4 1
     * -1 4 2
     * 5
     * 1 -1 5
     * Source : Amazon Interview Experience Set-323
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
    static void printVector( Vector<Integer> v, int s)
    {
        for (int j = s; j < v.size(); j++)
            System.out.print( v.get(j) + " ");
        System.out.println();
    }
    public static void printPathUtil(Node root, int k, Vector<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        printPathUtil(root.left, k, path);

        printPathUtil(root.right, k, path);
        int sum = 0;
        for(int i = path.size()-1;i>=0;i--) {
            sum +=path.get(i);
            if(sum == k) {
                printVector(path, i);
            }
        }
        path.remove(path.size()-1);
    }
    public static void printKPath(Node root, int k) {
        Vector<Integer> path = new Vector<>();
        printPathUtil(root, k, path);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        printKPath(root, k);
    }
}
