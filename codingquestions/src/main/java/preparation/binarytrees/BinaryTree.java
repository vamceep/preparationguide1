package preparation.binarytrees;


import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private static BinaryTreeNode root = null;
    private static boolean v1_exists = false;
    private static boolean v2_exists = false;

    public BinaryTreeNode getNode(int val) {
        return new BinaryTreeNode(val);
    }

    public static int lca(int n1, int n2) {
        BinaryTreeNode lca = lcaInternal(root, n1, n2);
        if (lca != null) {
            return lca.val;
        } else {
            throw new NullPointerException("No lca found");
        }
    }

    private static BinaryTreeNode lcaInternal(BinaryTreeNode root, int n1, int n2) {
        if (root == null) {
            return root;
        }

        if (root.val == n1 || root.val == n2) {
            return root;
        }

        BinaryTreeNode left = lcaInternal(root.left, n1, n2);
        BinaryTreeNode right = lcaInternal(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        } else {
            return (left != null ? left : right);
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void printInorder(BinaryTreeNode root) {
        if (root == null) {
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
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == val) {
            return true;
        }
        if (root.left != null && findPath(root.left, val, path)
                || (root.right != null && findPath(root.right, val, path))) {
            return true;
        }

        path.remove(root);
        return false;
    }

    public static BinaryTreeNode findLCA_method1_TwoLists_On(BinaryTreeNode root, int v1, int v2) {
        List<BinaryTreeNode> path1 = new ArrayList<>();
        List<BinaryTreeNode> path2 = new ArrayList<>();
        if (!findPath(root, v1, path1) || !findPath(root, v2, path2)) {
            return null;
        }
        int i = 0;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i).val != path2.get(i).val) {
                break;
            }
        }
        return path1.get(i - 1);
    }


    public static BinaryTreeNode findLCA_method2_SingleTraversal(BinaryTreeNode root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (root.val == v1 || root.val == v2) {
            return root;
        }
        BinaryTreeNode left = findLCA_method2_SingleTraversal(root.left, v1, v2);
        BinaryTreeNode right = findLCA_method2_SingleTraversal(root.right, v1, v2);
        if (left != null && right != null) {
            return root;
        }

        return (left != null ? left : right);
    }


    private static BinaryTreeNode findLCAUtil_method3(BinaryTreeNode root, int v1, int v2) {
        if(root == null) {
            return null;
        }
        BinaryTreeNode temp = null;
        if(root.val == v1) {
            v1_exists = true;
            temp = root;
        }
        if(root.val == v2) {
            v2_exists = true;
            temp = root;
        }
        BinaryTreeNode left = findLCAUtil_method3(root.left, v1, v2);
        BinaryTreeNode right = findLCAUtil_method3(root.right, v1, v2);
        if(temp != null) {
            return temp;
        }
        if(left != null && right != null) {
            return root;
        }
        return (left != null ? left : right);
    }
    private static BinaryTreeNode findLCA_method3_HandleNodesNotAvailable(BinaryTreeNode root, int v1, int v2) {
        v1_exists = false;
        v2_exists = false;
        BinaryTreeNode lca = findLCAUtil_method3(root, v1, v2);
        if(v1_exists && v2_exists){
            return lca;
        }
        return null;
    }

    public static void main(String[] args) {
        createSampleTree();
        BinarySearchTree.printInorder(root);
        int v1 = 33;
        int v2 = 25;
        BinaryTreeNode result = findLCA_method1_TwoLists_On(root, v1, v2);
        if (result != null) {
            System.out.println("\n LCA of " + v1 + " " + v2 + " is : " + result.val);
        } else {
            System.out.println("\n No LCA found for " + v1 + " " + v2);
        }

        // Works if both keys present and doesn't work properly if keys are missing
        result = findLCA_method2_SingleTraversal(root, v1, v2);
        if (result != null) {
            System.out.println("\n LCA of " + v1 + " " + v2 + " is : " + result.val);
        } else {
            System.out.println("\n No LCA found for " + v1 + " " + v2);
        }

        // works even either one or both nodes aren't exists
        result = findLCA_method3_HandleNodesNotAvailable(root, v1, v2);
        if (result != null) {
            System.out.println("\n LCA of " + v1 + " " + v2 + " is : " + result.val);
        } else {
            System.out.println("\n No LCA found for " + v1 + " " + v2);
        }
    }
}
