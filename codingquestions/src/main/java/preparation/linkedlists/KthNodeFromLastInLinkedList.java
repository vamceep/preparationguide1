package preparation.linkedlists;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class KthNodeFromLastInLinkedList {
    /**
     * print kth node from the last of a given linked list.
     *
     * https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
     */

    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private static Node root;

    public static  void addToList(int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        Node newNode = new Node(val);
        newNode.next = root;
        root = newNode;
    }

    public static void printKthNodeFromLast(int k) {
        Node second = root;
        Node first = root;
        if(k <= 0) {
            System.out.println("Invalid index");
            return;
        }
        if (second != null) {
            int count = 0;
            while (count < k) {
                if (second == null) {
                    System.out.println("Given " + k + " is greater than list lenght");
                    return;
                }
                second = second.next;
                count++;
            }

            while(second != null) {
                first = first.next;
                second = second.next;
            }
        }
        System.out.println("Value at " + k + " is " + first.val);
    }
    public static void main(String[] args) {
        root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);
        root.next.next.next.next = new Node(50);
        root.next.next.next.next.next = null;
        printKthNodeFromLast(4);
    }
}
