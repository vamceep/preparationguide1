package preparation.binarytrees;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PrintBinaryTreeTopView {
    /**
     * print binary tree in top view.
     * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
     * Ex:
     *        1
     *     /     \
     *    2       3
     *   /  \    / \
     *  4    5  6   7
     * Top view of the above binary tree is
     * 4 2 1 3 7
     *
     *         1
     *       /   \
     *     2       3
     *       \
     *         4
     *           \
     *             5
     *              \
     *                6
     * Top view of the above binary tree is
     * 2 1 3 6
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

    public static Node root;

    public static void TopView(Node root) {
        if(root == null) {
            System.out.println("root is null");
        }
        class QueueObj{
            int hd;
            Node node;
            QueueObj(Node node, int hd) {
                this.hd = hd;
                this.node = node;
            }
        }

        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Node> topView = new TreeMap<>();
        q.add(new QueueObj(root, 0));
        while(!q.isEmpty()) {
            QueueObj queueObj = q.poll();
            if(!topView.containsKey(queueObj.hd)) {
                topView.put(queueObj.hd, queueObj.node);
            }

            if(queueObj.node.left != null) {
                q.add(new QueueObj(queueObj.node.left, queueObj.hd - 1));
            }
            if(queueObj.node.right != null) {
                q.add(new QueueObj(queueObj.node.right, queueObj.hd + 1));
            }
        }
        for(Map.Entry<Integer, Node> entry : topView.entrySet()) {
            System.out.print(entry.getValue().val + " ");

        }
    }
    public static void main(String[] args) {
        PrintBinaryTreeTopView tree = new PrintBinaryTreeTopView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.TopView(tree.root);
        System.out.println();
        topViewWithoutQueue(tree.root);

    }

    /**
     * Method 2
     * using two variable and no queue
     * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
     *
     * d is distance from center
     * h height of current tree
     * add nodes according to distance 0, -1, +1 ... provided they aren't added earlier
     * based on the height.
     * i.e. for given height add node with distance. If node with same height with same
     * distance is not there, add it. otherwise, ignore it.
     */

    static TreeMap<Integer, Pair<Integer, Integer>> topViewList = new TreeMap<>();
    public static void fillTopView(Node root, int depth, int height) {
        if(root == null) {
            return;
        }
        if(topViewList.get(depth) == null) {
            topViewList.put(depth, new Pair(root.val, height));
        }else if(topViewList.get(depth).getValue() > height) {
            topViewList.put(depth, new Pair(root.val, height));
        }
        fillTopView(root.left, depth-1, height+1);
        fillTopView(root.right, depth+1, height+1);
    }
    public static void topViewWithoutQueue(Node root) {
        fillTopView(root, 0, 0);
        for(Map.Entry<Integer, Pair<Integer,Integer>> entry : topViewList.entrySet()){
            System.out.print(entry.getValue().getKey() + " ");
        }
    }
}
