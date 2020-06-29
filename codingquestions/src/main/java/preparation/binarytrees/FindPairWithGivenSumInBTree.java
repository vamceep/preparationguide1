package preparation.binarytrees;

import java.util.Stack;

public class FindPairWithGivenSumInBTree {
    /**
     * Find a pair with given sum in a Balanced BST
     * Given a Balanced Binary Search Tree and a target sum, write a function that returns true if there is a pair
     * with sum equals to target sum, otherwise return false. Expected time complexity is O(n) and only O(Logn) extra
     * space can be used. Any modification to Binary Search Tree is not allowed. Note that height of a Balanced BST
     * is always O(Logn).
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

    public boolean isPairWthSumPresent(Node root, int sum) {
        if(root == null) {
            return false;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        boolean d1 = false;
        boolean d2 = false;
        int v1 = 0;
        int v2 = 0;
        Node c1 = root;
        Node c2 = root;
        while(true) {
            while(!d1) {
                if(c1 != null) {
                    s1.push(c1);
                    c1 = c1.left;
                }else {
                    if(s1.isEmpty()) {
                        d1 = true;
                    }else {
                        c1 = s1.pop();
                        v1 = c1.val;
                        d1 = true;
                        c1 = c1.right;
                    }
                }
            }

            while(!d2) {
                if(c2 != null) {
                    s2.push(c2);
                    c2 = c2.right;
                }else {
                    if(s2.isEmpty()) {
                        d2 = true;
                    }else {
                        c2 = s2.pop();
                        v2 = c2.val;
                        d2 = true;
                        c2 = c2.left;
                    }
                }
            }

            if((v1 != v2) && (v1+v2) == sum) {
                System.out.println("Pair found for sum " + sum + " v1: " + v1 + " v2: " + v2);
                return true;
            }else if( (v1+v2) > sum) {
                d2 =  false;
            }else if( (v1+v2) < sum) {
                d1 = false;
            }

            if(v1 >= v2) {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        /**
         *              15
         *             / \
         *            10  20
         *           / \  / \
         *          8 12 16 25
         */
        FindPairWithGivenSumInBTree tree = new FindPairWithGivenSumInBTree();
        root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        int target = 25;
        if(tree.isPairWthSumPresent(root, target)) {
            System.out.println("present... ");
        }else {
            System.out.println("Not present...");
        }
    }
}
