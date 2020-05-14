package preparation.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOddEvenLevelDifference {
    /**
     * Given a binary tree, consider root level is even
     * followed by odd and even, write a function to return difference of
     * sum of all node values of even level and odd level.
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
    private static Node root1, root2;

    public static int getEvenOddLevelDiff(Node root) {
        if(root == null) {
            return 0;
        }
        return root.val - (getEvenOddLevelDiff(root.left) + getEvenOddLevelDiff(root.right));
    }

    static class QNode {
        Node node;
        int level;
        public QNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static int getEvenOddLEvelDiffNoRec(Node root) {
        if(root == null) {
            return 0;
        }
        Queue<QNode> qNodes = new LinkedList<>();
        int level = 0;
        int oddSum = 0;
        int evenSum = 0;
        qNodes.add(new QNode(root, level));
        while (!qNodes.isEmpty()) {
            QNode qNode = qNodes.remove();
            if(qNode.level % 2 == 0) {
                evenSum += qNode.node.val;
            }else {
                oddSum += qNode.node.val;
            }

            if(qNode.node.left != null) {
                qNodes.add(new QNode(qNode.node.left, qNode.level+1));
            }
            if(qNode.node.right != null) {
                qNodes.add(new QNode(qNode.node.right, qNode.level+1));
            }
        }
        return (evenSum - oddSum);
    }
    public static void main(String[] args) {
        BinaryTreeOddEvenLevelDifference tree = new BinaryTreeOddEvenLevelDifference();

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6); // sub tree true val is 6
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);

        System.out.println("Result: " + getEvenOddLevelDiff(root1));
        System.out.println("Result: " + getEvenOddLevelDiff(root2));

        System.out.println("Result: " + getEvenOddLEvelDiffNoRec(root1));
        System.out.println("Result: " + getEvenOddLEvelDiffNoRec(root2));
    }
}
