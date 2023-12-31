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
    public static int probPalPaths = 0;
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
                probPalPaths++;
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
        System.out.println("test case1");
        test1();
        System.out.println("test case2");
        test2();
    }
    public static void test2() {
        PrintAllPathsFromRootAndPalindromPaths tree = new PrintAllPathsFromRootAndPalindromPaths();
        root = new Node(2);
        root.left = new Node(6);
        root.right = new Node(8);

        root.right.left = new Node(8);
        root.right.right = new Node(5);

        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(8);
        root.right.right.right.left = new Node(2);
        printAllPaths();
        System.out.println("Probable palindrom paths: " + probPalPaths);
    }
    public static void test1() {
        PrintAllPathsFromRootAndPalindromPaths tree = new PrintAllPathsFromRootAndPalindromPaths();
        tree.root = new Node(2);
        tree.root.right = new Node(1);
        tree.root.left = new Node(1);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.left.right.right = new Node(1);
        printAllPaths();
        System.out.println("Probable palindrom paths: " + probPalPaths);
    }
}
