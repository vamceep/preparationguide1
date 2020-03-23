package preparation.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePrinting {
    
    // function prints each level left -> right -> right ->left
    // pushing right first then left results above
    // for right ->left -> left -> right, push left first then right first

    public static class Node {

        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static ArrayList<Integer> getZigZag_LeftToRight_RightToLeft(Node root) {

        ArrayList<Integer> result = new ArrayList<>();
        if(root ==null) {
            return result;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        boolean left_print = true;
        while(!stack1.empty() || !stack2.empty()) {
            if(left_print) {
                while (!stack1.empty()) {
                    Node temp = stack1.pop();
                    result.add(temp.val);
                    if(temp.right != null) {
                        stack2.push(temp.right);
                    }
                    if(temp.left != null) {
                        stack2.push(temp.left);
                    }

                }
                left_print = false;
            }else {
                while (!stack2.empty()) {
                    Node temp = stack2.pop();
                    result.add(temp.val);
                    if(temp.left != null) {
                        stack1.push(temp.left);
                    }
                    if(temp.right != null) {
                        stack1.push(temp.right);
                    }

                }
                left_print = true;
            }
        }
        return result;
    }

    public static ArrayList<Integer> printLevelByLevel(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            result.add(temp.val);
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
        return result;
    }
    public static void printInorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(" " + root.val);
        printInorder(root.left);

        printInorder(root.right);
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.left.left.left = new Node(8);
        node.left.left.right = new Node(9);
        printInorder(node);
        ArrayList<Integer> result = getZigZag_LeftToRight_RightToLeft(node);
        System.out.println("\nPrinting zig zag: ");
        result.forEach((val) -> {
            System.out.print(" " + val);
        });

        System.out.println("\nPrinting level by level");

        result = printLevelByLevel(node);
        result.forEach((val) -> {
            System.out.print(" " + val);
        });
    }
}
