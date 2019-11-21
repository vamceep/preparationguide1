package preparation.binarytrees;


public class BinaryTree {
    private BinaryTreeNode root = null;

    public BinaryTreeNode getNode(int val) {
        return new BinaryTreeNode(val);
    }

    public int lca(int n1, int n2) {
        BinaryTreeNode lca = lcaInternal(root, n1, n2);
        if(lca != null) {
            return lca.val;
        } else {
            throw new NullPointerException("No lca found");
        }
    }
    private BinaryTreeNode lcaInternal(BinaryTreeNode root, int n1, int n2) {
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

    public void createSampleTree() {
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
}
