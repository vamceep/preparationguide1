package preparation.binarytrees;

public class BinarySearchTree {
    BinaryTreeNode root = null;

    public BinarySearchTree() {
    }

    public void add(int val) {
        if(root == null) {
            root = new BinaryTreeNode(val);
            return;
        }

    }
}
