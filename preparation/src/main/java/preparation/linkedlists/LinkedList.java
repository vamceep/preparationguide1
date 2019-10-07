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
            System.out.println(tNode.val);
            tNode = tNode.next;
        }
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
}
