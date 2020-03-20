package preparation.binarytrees;

public class LowestCommonAnsesterWithNodeMissing {
    /**
     * Give a binary tree and two values ( values may or may not present)
     * find the lowest common ancestor of two values
     * This solution is includes if node values aren't present.
     *
     * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
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
    private static Node root;
    static boolean v1 = false, v2= false;
    public static Node findLCAUtil(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        Node temp = null;
        if(root.val == n1) {
            v1 = true;
            temp = root;
        }
        if(root.val == n2) {
            v2 = true;
            temp = root;
        }
        Node left = findLCAUtil(root.left, n1, n2);
        Node right = findLCAUtil(root.right,n1,n2);
        if(temp != null) {
            return temp;
        }
        if(left != null && right != null) {
            return root;
        }
        return (left !=null) ? left : right;
    }
    public static Node findLCA(int n1, int n2) {
        v1 = false;
        v2 = false;
        Node n = findLCAUtil(root, n1,n2);
        if(v1 && v2) {
            return n;
        }
        return null;
    }
    public static void main(String[] args) {

        LowestCommonAnsesterWithNodeMissing tree = new LowestCommonAnsesterWithNodeMissing();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.val);
        else
            System.out.println("Keys are not present");

        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.val);
        else
            System.out.println("Keys are not present");
    }

}
