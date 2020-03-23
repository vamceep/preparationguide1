package preparation.binarytrees;


import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
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
    static Node root = null;
    private static boolean v1_exists = false;
    private static boolean v2_exists = false;

    public Node getNode(int val) {
        return new Node(val);
    }

    public static int lca(int n1, int n2) {
        Node lca = lcaInternal(root, n1, n2);
        if (lca != null) {
            return lca.val;
        } else {
            throw new NullPointerException("No lca found");
        }
    }

    private static Node lcaInternal(Node root, int n1, int n2) {
        if (root == null) {
            return root;
        }

        if (root.val == n1 || root.val == n2) {
            return root;
        }

        Node left = lcaInternal(root.left, n1, n2);
        Node right = lcaInternal(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        } else {
            return (left != null ? left : right);
        }
    }

    public Node getRoot() {
        return root;
    }

    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public static void createSampleTree() {
        root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(15);
        root.left.right = new Node(30);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(10);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(50);

        root.left.right.left.left = new Node(60);
        root.left.right.left.right = new Node(20);

        root.right.left = new Node(22);
        root.right.right = new Node(25);


        root.right.left.left = new Node(33);
    }

    public static boolean findPath(Node root, int val, List<Node> path) {
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

    public static Node findLCA_method1_TwoLists_On(Node root, int v1, int v2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
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


    public static Node findLCA_method2_SingleTraversal(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (root.val == v1 || root.val == v2) {
            return root;
        }
        Node left = findLCA_method2_SingleTraversal(root.left, v1, v2);
        Node right = findLCA_method2_SingleTraversal(root.right, v1, v2);
        if (left != null && right != null) {
            return root;
        }

        return (left != null ? left : right);
    }


    private static Node findLCAUtil_method3(Node root, int v1, int v2) {
        if(root == null) {
            return null;
        }
        Node temp = null;
        if(root.val == v1) {
            v1_exists = true;
            temp = root;
        }
        if(root.val == v2) {
            v2_exists = true;
            temp = root;
        }
        Node left = findLCAUtil_method3(root.left, v1, v2);
        Node right = findLCAUtil_method3(root.right, v1, v2);
        if(temp != null) {
            return temp;
        }
        if(left != null && right != null) {
            return root;
        }
        return (left != null ? left : right);
    }
    private static Node findLCA_method3_HandleNodesNotAvailable(Node root, int v1, int v2) {
        v1_exists = false;
        v2_exists = false;
        Node lca = findLCAUtil_method3(root, v1, v2);
        if(v1_exists && v2_exists){
            return lca;
        }
        return null;
    }

    public static void main(String[] args) {
        createSampleTree();
        printInorder(root);
        int v1 = 33;
        int v2 = 25;
        Node result = findLCA_method1_TwoLists_On(root, v1, v2);
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
