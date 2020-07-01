package preparation.binarytrees;

import java.util.Stack;

public class ModifyBinaryTreeForPreorder {
    /**
     * Modify a binary tree to get preorder traversal using right pointers only
     * Given a binary tree. Modify it in such a way that after modification you can have a preorder traversal
     * of it using only the right pointers. During modification, you can use right as well as left pointers.
     *
     * Examples:
     *
     * Input :    10
     *           /   \
     *         8      2
     *       /  \
     *     3     5
     * Output :    10
     *               \
     *                8
     *                 \
     *                  3
     *                   \
     *                    5
     *                     \
     *                      2
     * Explanation : The preorder traversal
     * of given binary tree is 10 8 3 5 2.
     *
     * https://www.geeksforgeeks.org/modify-binary-tree-get-preorder-traversal-using-right-pointers/
     */

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
    public static void modify(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node preOrder = null;
        while (stack.isEmpty() == false) {
            Node node = stack.peek();
            stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            if(preOrder != null) {
                preOrder.right = node;
            }
            preOrder = node;
        }
    }

    public static void printPreOrder(Node node) {
        Node temp = node;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.right;
        }
        System.out.println();
    }
    public static void main(String[] args) {
         /* Constructed binary tree is  
                    10  
                / \  
                8     2  
            / \      
            3     5  
        */
       Node root = new Node(10);
       root.left = new Node(8);
       root.right = new Node(2);
       root.left.left = new Node(3);
       root.left.right = new Node(5);
        modify(root);
        printPreOrder(root);
    }
}
