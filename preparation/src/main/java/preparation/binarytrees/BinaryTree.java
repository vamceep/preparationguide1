package preparation.binarytrees;

import org.omg.CORBA.PUBLIC_MEMBER;

public class BinaryTree {
    public class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private Node root = null;

    public Node getNode(int val) {
        return new Node(val);
    }

    public int lca(int n1, int n2) {
        Node lca = lcaInternal(root, n1, n2);
        if(lca != null) {
            return lca.val;
        } else {
            throw new NullPointerException("No lca found");
        }
    }
    private Node lcaInternal(Node root, int n1, int n2) {
        if(root == null) {
            return root;
        }

        if(root.val == n1 || root.val == n2) {
            return root;
        }

        Node left = lcaInternal(root.left, n1, n2);
        Node right = lcaInternal(root.right, n1, n2);
        if(left != null && right != null) {
            return root;
        }else {
            return (left != null ? left : right);
        }
    }

    public Node getRoot() {
        return root;
    }
    public void printInorder(Node root) {
        if(root == null) {
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public void createSampleTree() {
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
}
