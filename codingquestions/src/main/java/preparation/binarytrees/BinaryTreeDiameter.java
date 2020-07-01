package preparation.binarytrees;

public class BinaryTreeDiameter {
    /**
     *
     *
     * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
     */
    public static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static Node root;
    class Height {
        int h;
    }
    public int diameterUtil(Node root, Height height) {
        Height lheight = new Height();
        Height rheight = new Height();
        if(root == null) {
            height.h =0;
            return 0;
        }
        int ldiameter = diameterUtil(root.left, lheight);
        int rdiameter = diameterUtil(root.right, rheight);
        height.h = Math.max(lheight.h, rheight.h) +1;
        int diameter = Math.max(lheight.h+ rheight.h +1, Math.max(ldiameter , rdiameter));
        return diameter;
    }
    // O(n2) solution
    public int diameter(Node root) {
        Height height = new Height();
        return diameterUtil(root, height);
    }

    /**
     * O(n) solution:
     */
    class Result {
        int res = Integer.MIN_VALUE;
    }

    public int diameterViaHeight(Node root, Result result) {
        if(root == null) {
            return 0;
        }
        int lheight = diameterViaHeight(root.left, result);
        int rheigt = diameterViaHeight(root.right, result);

        result.res = Math.max(result.res, 1+ lheight + rheigt);
        return 1+ Math.max(lheight, rheigt);
    }
    public int diameterOn(Node root) {
        Result result = new Result();
        if(root == null) {
            result.res = 0;
        }else {
            diameterViaHeight(root, result);
        }
        return result.res;
    }
    public static void main(String[] args) {
        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("diameter: " + tree.diameter(root));

        System.out.println("diameter O(n): " + tree.diameterOn(root));
    }
}
