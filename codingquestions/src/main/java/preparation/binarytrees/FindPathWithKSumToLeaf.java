package preparation.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class FindPathWithKSumToLeaf {
    /**
     * Given a binary tree and sum find the path from root to leaf
     * if found, print path.
     */
    public static class Node {

        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean findPathUtils(Node root, int sum, int currentSum, List<Node> pathList) {
        if(root == null) {
            return false;
        }
        currentSum += root.val;
        pathList.add(root);
        if(currentSum == sum && root.left == null && root.right == null) {
            return true;
        }

//        if(root.left != null && findPathUtils(root.left, sum, currentSum, pathList)) {
//            return true;
//        }
//
//        if(root.right != null && findPathUtils(root.right, sum, currentSum, pathList)) {
//            return true;
//        }
        if( findPathUtils(root.left, sum, currentSum, pathList)
                || findPathUtils(root.right, sum, currentSum, pathList)) {
            return true;
        }
        pathList.remove(root);
        return false;
    }
    public static void printPath(Node root, int sum) {
        int currentSum = 0;
        List<Node> pathList = new LinkedList<>();
        boolean res = findPathUtils(root, sum, currentSum, pathList);
        if(res) {
            for(int i = 0; i< pathList.size();i++) {
                System.out.println(pathList.get(i).val + " ");
            }
        }else {
            System.out.println("No path found ");
        }
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
        int k = 7;
        printPath(root, k);
    }
}
