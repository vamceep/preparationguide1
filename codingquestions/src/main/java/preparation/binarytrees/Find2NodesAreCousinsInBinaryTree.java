package preparation.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class Find2NodesAreCousinsInBinaryTree {

    /**
     * Given a binary tree and two nodes, check if they are cousins are not
     * https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
     * Example:
     *      6
     *    /   \
     *   3     5
     *  / \   / \
     * 7   8 1   3
     * Say two node be 7 and 1, result is TRUE.
     * Say two nodes are 3 and 5, result is FALSE.
     * Say two nodes are 7 and 5, result is FALSE.
     *
     * Set2: https://www.geeksforgeeks.org/check-if-two-nodes-are-cousins-in-a-binary-tree-set-2/
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
    static Node root;

    static class QNode {
        Node node;
        Node parent;
        int level;
        public QNode(Node node, Node parent, int level) {
            this.node = node;
            this.parent = parent;
            this.level = level;
        }

    }
    public static boolean isCousin2(Node root, Node n1, Node n2) {
        if(root == null || n1 == null || n2 == null) {
            return false;
        }
        Queue<QNode> qNodes = new LinkedList<>();
        int level = 0;
        QNode qn1 = null;
        QNode qn2 = null;
        qNodes.add(new QNode(root, root, level));
        while(!qNodes.isEmpty()) {
            QNode qNode = qNodes.remove();
            if(qNode.node.left != null) {
                qNodes.add(new QNode(qNode.node.left, qNode.node, qNode.level+1));
            }
            if(qNode.node.right != null) {
                qNodes.add(new QNode(qNode.node.right, qNode.node, qNode.level+1));
            }
            if(qn1 == null && qNode.node == n1) {
                qn1 = qNode;
            }

            if(qn2 == null && qNode.node == n2) {
                qn2 = qNode;
            }
            if(qn1 != null && qn2 != null) {
                break;
            }
        }
        if(qn1 != null && qn2 != null) {
            if(qn1.level == qn2.level  && qn1.parent != qn2.parent) {
                return true;
            }
        }
        return false;
    }

    public static int level(Node root, Node n1, int level) {
        if(root == null) {
            return 0;
        }
        if(root.val == n1.val) {
            return level;
        }

        int l = level(root.left, n1, level+1);
        if(l != 0) {
            return l;
        }
        return level(root.right,n1,level+1);
    }

    public static boolean isSibling(Node root, Node n1, Node n2) {
        if(root == null) {
            return false;
        }
        if((root.left == n1 || root.left == n1) && (root.right == n2 || root.right == n2) ) {
            return true;
        }
        return isSibling(root.left, n1, n2) || isSibling(root.right,n1, n2);
    }
    public static boolean isCousin(Node root, Node n1, Node n2) {
        return (level(root,n1,1) == level(root,n2,1) && !isSibling(root,n1,n2));
    }
    public static void main(String[] args) {
        Find2NodesAreCousinsInBinaryTree tree = new Find2NodesAreCousinsInBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(15);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        Node n1, n2;
        n1 = tree.root.left.right.right;
        n2 = tree.root.right.left.right;
//        n1 = tree.root.left.left;
//        n2 = tree.root.left.right;
        if (tree.isCousin(tree.root, n1, n2))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (tree.isCousin2(tree.root, n1, n2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
