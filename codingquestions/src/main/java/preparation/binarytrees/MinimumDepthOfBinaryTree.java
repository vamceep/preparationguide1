package preparation.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    /**
     * Given a binary tree find the minimum depth
     * https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
     * Order is O(n)
     * problem with this solution is we traversal all nodes
     * say if a leaf is close to root, we always traversal all nodes then return result
     *
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

    public static int minimumDepth(Node root) {
        if(root == null) {
            return 0;
        }
        // both left and right of leaf nodes should be present
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null) {
            return minimumDepth(root.right);
        }
        if(root.right == null) {
            return minimumDepth(root.left);
        }

        return Math.min(minimumDepth(root.left), minimumDepth(root.right)) +1;
    }
    public static int minimumDepth() {
        return minimumDepth(root);
    }

    /**
     * Better solution :
     *  it still O(n) in worst case
     *  but for cases like a leaf is close to root we no need to traverse all nodes
     *  Idea is : do breath first traversal and check is there any node is a leaf.
     *  if found return the height/depth counter.
     */

    static class qItem {
        Node node;
        int depth;
        public qItem(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public static int minDepthItr(Node root) {
        if(root ==  null) {
            return 0;
        }
        Queue<qItem> qItemQueue = new LinkedList<>();
        // init depth as 1
        qItem qi = new qItem(root, 1);
        qItemQueue.add(qi);
        while (qItemQueue.isEmpty() == false) {
            qi = qItemQueue.remove();
            Node node = qi.node;
            int depth = qi.depth;

            if(node.left == null && node.right == null) {
                return depth;
            }
            if(node.left != null) {
                qi.node = node.left;
                qi.depth = depth+1;
                qItemQueue.add(qi);
            }
            if(node.right != null) {
                qi.node = node.right;
                qi.depth = depth+1;
                qItemQueue.add(qi);
            }
        }
        return 0;
    }
    public static int minDepthItr() {
        return minDepthItr(root);
    }
    public static void main(String[] args) {
        MinimumDepthOfBinaryTree tree = new MinimumDepthOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The minimum depth of "+"binary tree is : " + tree.minimumDepth());
        System.out.println("The minimum depth of "+"binary tree is (itr): " + tree.minDepthItr());
    }
}
