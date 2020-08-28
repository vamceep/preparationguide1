package preparation.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointers {
    /**
     * given a linked list with a random pointer, clone the linked list
     * https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
     *
     * https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/?ref=rp
     */

    static class Node {
        int val;
        Node random;
        Node next;
        public Node(int val) {
            this.val = val;
            this.random = this.next = null;
        }
    }

    public static Node head;

    public CloneLinkedListWithRandomPointers(Node node) {
        this.head = node;
    }
    public static void add(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }
    public static void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public CloneLinkedListWithRandomPointers clone() {
        Node origNode = head;
        Node cloneNode = null;
        Map<Node, Node> map = new HashMap<>();
        while(origNode != null) {
            cloneNode = new Node(origNode.val);
            map.put(origNode, cloneNode);
            origNode = origNode.next;
        }

        origNode = head;
        while (origNode != null) {
            cloneNode = map.get(origNode);
            cloneNode.random = map.get(origNode.random);
            cloneNode.next = map.get(origNode.next);
            origNode = origNode.next;
        }
        return new CloneLinkedListWithRandomPointers(map.get(head));
    }

    public static Node CloneMethod2(Node root) {
        if(root == null) {
            return null;
        }

        Node temp = root;
        Node temp2;
        Node clonedNode = null;
        while(temp != null) {
            Node newNode = new  Node(temp.val);
            temp2 = temp.next;
            temp.next = newNode;
            newNode.next = temp2;
            temp = temp.next.next;
        }

        temp = root;
        while(temp != null && temp.next != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;

        }

        temp = root;
        clonedNode = temp.next;
        while(temp != null) {
            temp2 = temp.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
            if(temp2.next != null) {
                temp2.next = temp2.next.next;
            }
            temp = temp.next;
        }
        return clonedNode;
    }

    public static  void printNode(Node root) {
        Node temp = root;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CloneLinkedListWithRandomPointers list = new CloneLinkedListWithRandomPointers(new Node(5));
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        // Setting up random references. 
        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
                list.head.next;

        // Making a clone of the original linked list. 
        CloneLinkedListWithRandomPointers clone = list.clone();

        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();

        System.out.println("Original linked list");
        list.print();
        Node cloned = CloneMethod2(head);
        System.out.println("\nCloned linked list");
        printNode(cloned);
    }
}
