package preparation.binarytrees;

import java.util.Vector;

public class BinarySearchTree {
    public static BinaryTreeNode addToBinaryTree(BinaryTreeNode root, int val) {
        if(root == null) {
            root = new BinaryTreeNode(val);
            return root;
        }
        if(root.val < val) {
           root.right = addToBinaryTree(root.right, val);
        }else if(root.val > val) {
            root.left = addToBinaryTree(root.left, val);
        }
        return root;
    }

    public static void printInorder(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(" " + root.val);
        printInorder(root.right);
    }

    public static void printPathSum(BinaryTreeNode root, int sum, int current_sum, Vector<Integer> path) {
        if(root == null) {
            return;
        }
        current_sum += root.val;
        path.add(root.val);
        if(current_sum == sum) {
            System.out.println("Path: ");
            path.forEach((val) -> System.out.print(val + " "));
        }
        if(root.left != null) {
            printPathSum(root.left, sum, current_sum, path);
        }

        if(root.right != null) {
            printPathSum(root.right, sum, current_sum, path);
        }

        path.remove(path.size()-1);
    }

    public static void printPaths(BinaryTreeNode root, int sum) {
        printPathSum(root, sum, 0, new Vector<>());
    }
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        addToBinaryTree(node, 28);
        addToBinaryTree(node, 13);
        addToBinaryTree(node, 14);
        addToBinaryTree(node, 15);
        addToBinaryTree(node, 21);
        addToBinaryTree(node, 22);
        addToBinaryTree(node, 23);
        addToBinaryTree(node, 24);

        printInorder(node);
        System.out.println();
        System.out.println("Path to sum ...");
        int sum = 38;
        printPaths(node, sum);

    }
}
