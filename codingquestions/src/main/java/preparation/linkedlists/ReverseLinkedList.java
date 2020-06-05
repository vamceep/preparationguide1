package preparation.linkedlists;

public class ReverseLinkedList {
    /**
     * give a linked list revers it.
     * write both iterative and recusive functions
     */

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void print(Node head) {
        Node tNode = head;
        while(tNode != null) {
            System.out.print(" " + tNode.val);
            tNode = tNode.next;
        }
        System.out.println();
    }

    public static Node reverseIterate(Node head) {
        Node prev = null;
        Node temp = head;
        while(temp != null) {
            Node tnext = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tnext;
        }
        return prev;
    }

    public static Node reverseRec(Node head) {
        if (head == null) {
            return head;
        }
        if(head.next == null) {
            return head;
        }
        Node rest = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        print(node);

        Node reversed = reverseRec(node);
        print(reversed);

//        Node reversed = reverseIterate(node);
//        print(reversed);

    }
}
