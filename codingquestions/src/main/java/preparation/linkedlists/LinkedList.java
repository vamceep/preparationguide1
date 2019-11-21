package preparation.linkedlists;

public class LinkedList {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    };

    Node head = null;
    public LinkedList() {
    }

    public void add(int val) {
        Node n = new Node(val);
        if(head == null) {
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public void print() {
        Node tNode = head;
        while(tNode != null) {
            System.out.print(" " + tNode.val);
            tNode = tNode.next;
        }
        System.out.println();
    }

    private Node reverseInternal(Node ll) {
        if (ll == null) {
            return null;
        }

        if (ll.next == null) {
            return ll;
        }
        Node rest = reverseInternal(ll.next);
        ll.next.next = ll;
        ll.next = null;
        return rest;
    }

    public void reverse() {
        this.head = reverseInternal(head);
    }

    public void reverseItr() {
        Node tnode = head;

        Node prev = null, next = null;
        while (tnode != null) {
            next = tnode.next;
            tnode.next = prev;
            prev = tnode;
            tnode = next;
        }
        head = prev;
    }

    public Node reverseInput(Node headNode) {
        Node tnode = headNode;

        Node prev = null, next = null;
        while (tnode != null) {
            next = tnode.next;
            tnode.next = prev;
            prev = tnode;
            tnode = next;
        }
        headNode = prev;
        return headNode;
    }

    public boolean isPalindrom(Node headnode) {

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
