package preparation.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfCousinsOfGivenBinaryTreeNode {
    /**
     * Given a binary tree and data value of a node. The task is to find the sum of cousin nodes of given node. If given node has no cousins then return -1.
     * Note: It is given that all nodes have distinct values and the given node exists in the tree.
     *
     * Examples:
     *
     * Input:
     *                 1
     *               /  \
     *              3    7
     *            /  \  / \
     *           6   5  4  13
     *              /  / \
     *             10 17 15
     *          key = 13
     * Output: 11
     * Cousin nodes are 5 and 6 which gives sum 11.
     *
     * Input:
     *                 1
     *               /  \
     *              3    7
     *            /  \  / \
     *           6   5  4  13
     *              /  / \
     *             10 17 15
     *            key = 7
     * Output: -1
     * No cousin nodes of node having value 7.
     *
     * https://www.geeksforgeeks.org/sum-of-cousins-of-a-given-node-in-a-binary-tree/?ref=rp
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
    public static int findCousinSum(Node root, int val) {

        if(root == null) {
            return  -1;
        }
        if(root.val == val) {
            return -1;
        }

        int currentSum = 0;
        int size;
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        boolean found = false;

        while(!queue.isEmpty()) {
            if(found == true) {
                return currentSum;
            }
            size = queue.size();
            currentSum = 0;
            while(size > 0) {
                Node n = queue.remove();
                if((n.left != null && n.left.val == val) || (n.right != null && n.right.val == val)) {
                    found = true;
                }else {
                    if(n.left != null) {
                        currentSum += n.left.val;
                        queue.add(n.left);
                    }
                    if(n.right != null) {
                        currentSum += n.right.val;
                        queue.add(n.right);
                    }
                }
                size--;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.left.right.left = new Node(10);
        root.right.left = new Node(4);
        root.right.right = new Node(13);
        root.right.left.left = new Node(17);
        root.right.left.right = new Node(15);

        System.out.print( findCousinSum(root, 13) + "\n");

        System.out.print( findCousinSum(root, 7) + "\n");
        System.out.print( findCousinSum(root, 15) + "\n");
    }
}
