package preparation.binarytrees;

public class BynaryTeeToDLL {
    /**
     * convert binary tree to doubly linked list
     *
     * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/?ref=rp
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
    public static Node root, head = null;

    public static void BToDLL(Node root) {
        if(root == null) {
            return;
        }

        BToDLL(root.right);
        root.right = head;
        if(head != null) {
            head.left = root;
        }
        head = root;
        BToDLL(root.left);
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.right;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BynaryTeeToDLL tree = new BynaryTeeToDLL();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);

        tree.BToDLL(tree.root);
        tree.printList(tree.head);
    }
}
