package preparation.binarytrees;


import preparation.linkedlists.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BinaryTree {
    private static BinaryTreeNode root = null;

    public BinaryTreeNode getNode(int val) {
        return new BinaryTreeNode(val);
    }

    public static int lca(int n1, int n2) {
        BinaryTreeNode lca = lcaInternal(root, n1, n2);
        if(lca != null) {
            return lca.val;
        } else {
            throw new NullPointerException("No lca found");
        }
    }
    private static BinaryTreeNode lcaInternal(BinaryTreeNode root, int n1, int n2) {
        if(root == null) {
            return root;
        }

        if(root.val == n1 || root.val == n2) {
            return root;
        }

        BinaryTreeNode left = lcaInternal(root.left, n1, n2);
        BinaryTreeNode right = lcaInternal(root.right, n1, n2);
        if(left != null && right != null) {
            return root;
        }else {
            return (left != null ? left : right);
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }
    public void printInorder(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public static void createSampleTree() {
        root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(15);
        root.left.right = new BinaryTreeNode(30);
        root.left.left.left = new BinaryTreeNode(1);
        root.left.left.right = new BinaryTreeNode(10);

        root.left.right.left = new BinaryTreeNode(3);
        root.left.right.right = new BinaryTreeNode(50);

        root.left.right.left.left = new BinaryTreeNode(60);
        root.left.right.left.right = new BinaryTreeNode(20);

        root.right.left = new BinaryTreeNode(22);
        root.right.right = new BinaryTreeNode(25);


        root.right.left.left = new BinaryTreeNode(33);
    }

    public static boolean findPath(BinaryTreeNode root, int val, List<BinaryTreeNode> path) {
        if(root == null) {
            return false;
        }
        path.add(root);
        if(root.val == val) {
            return true;
        }
        if(root.left != null && findPath(root.left, val, path)
            || (root.right != null && findPath(root.right, val, path))){
            return true;
        }

        path.remove(root);
        return false;
    }
    public static BinaryTreeNode findLCA(BinaryTreeNode root, int v1, int v2) {
        List<BinaryTreeNode> path1 = new ArrayList<>();
        List<BinaryTreeNode> path2 = new ArrayList<>();
        if(!findPath(root,v1, path1) || !findPath(root, v2, path2)) {
            return null;
        }
        int i = 0;
        for(i=0; i < path1.size() && i < path2.size();i++) {
            if(path1.get(i).val != path2.get(i).val) {
                break;
            }
        }
        return path1.get(i-1);
    }
    public static void main(String[] args) {
        createSampleTree();
        BinarySearchTree.printInorder(root);
        int v1 = 33;
        int v2 = 25;
        BinaryTreeNode result = findLCA(root, v1, v2);
        if(result != null) {
            System.out.println("\n LCA of " + v1 + " " + v2 + " is : " + result.val);
        }else {
            System.out.println("\n No LCA found for " + v1 + " " + v2);
        }
    }
}
