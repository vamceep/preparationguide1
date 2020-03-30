package preparation.binarytrees;

import jdk.nashorn.api.tree.Tree;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class PrintBinaryTreeVertical {
    /**
     * Print a binary tree in vertical order
     * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
     * Time complexity O(n log n)
     * Ex:
     *            1
     *         /    \
     *        2      3
     *       / \   /   \
     *      4   5  6   7
     *                /  \
     *               8   9
     *
     *
     * The output of print this tree vertically will be:
     * 4
     * 2
     * 1 5 6
     * 3 8
     * 7
     * 9
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

    public static void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> map) {
        if(root == null) {
            return;
        }
        Vector<Integer> list = map.get(hd);
        if(list == null) {
            list = new Vector<>();
        }
        list.add(root.val);
        map.put(hd, list);
        getVerticalOrder(root.left, hd-1, map);
        getVerticalOrder(root.right, hd+1, map);
    }

    public static void printVerticalOrder(Node root) {
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        int horizontalDistance = 0; // for root it is 0
        getVerticalOrder(root, horizontalDistance, map);
        for(Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
