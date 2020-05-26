package preparation.binarytrees;

import java.util.HashSet;

public class PrintAllPathsFromRootAndPalindromPaths {
    /**
     * Give a binary tree/ bst, print all paths from root to leaf
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

    public static boolean canBePalindrom(int[] arr, int len) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< len;i++) {
            set.add(arr[i]);
        }
        if(set.size() == len/2 || set.size() == (len+1) /2 ) {
            return true;
        }
        return false;
    }
    public static boolean isPalindrom(int[] arr, int len) {
        int l =0;
        int r = len-1;
        while(l < r) {
            if(arr[l++] != arr[r--]) {
                return false;
            }
        }
        return true;
    }
    public static void getAllPaths(Node root, int length, int[] list) {
        if(root == null) {
            return;
        }

        list[length] = root.val;
        length++;
        if(root.left == null && root.right == null) {
            for(int i=0;i<length;i++) {
                System.out.print(list[i] + " ");
            }
            if(isPalindrom(list, length)) {
                System.out.println(" : a palindrom");
            }else if(canBePalindrom(list, length) ) {
                System.out.println(" : can be palindrom");
            }else {
                System.out.println();
            }
        }
        if(root.left != null) {
            getAllPaths(root.left, length, list);
        }
        if(root.right != null) {
            getAllPaths(root.right, length, list);
        }
    }
    public static void printAllPaths() {
        int[] list = new int[1000];

        getAllPaths(root, 0, list);

    }
    public static void main(String[] args) {
        PrintAllPathsFromRootAndPalindromPaths tree = new PrintAllPathsFromRootAndPalindromPaths();
        /**
         *              26
         *         6       3
         *     4      6         26
         *       30
         */
        tree.root = new Node(26);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(26);
        tree.root.left = new Node(6);
        tree.root.left.left = new Node(4);
        tree.root.left.left.right = new Node(30);
        tree.root.left.right = new Node(6);
        printAllPaths();
    }
}
