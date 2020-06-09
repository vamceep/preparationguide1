package preparation.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    /**
     * Connect nodes at same level
     * Write a function to connect all the adjacent nodes at the same level in a binary tree.
     * Structure of the given Binary Tree node is like following.
     * filter_none
     * brightness_4
     * struct node {
     *     int data;
     *     struct node* left;
     *     struct node* right;
     *     struct node* nextRight;
     * }
     * https://www.geeksforgeeks.org/connect-nodes-at-same-level/
     */

    public static class Node {
        int val;
        Node left;
        Node right;
        Node nextRight;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.nextRight = null;
        }
    }
    public static Node root;

    public void connect(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = null;
            int n = queue.size();
            for(int i =0; i< n;i++) {
                Node node = queue.poll();
                if(temp == null) {
                    temp = node;
                }else {
                    temp.nextRight = node;
                    temp  = node;
                }
                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();
        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.connect(root);
    }
}
