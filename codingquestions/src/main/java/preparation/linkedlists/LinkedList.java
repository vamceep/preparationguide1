package preparation.linkedlists;

public class LinkedList {
    Node head = null;
    public LinkedList() {
    }
    public LinkedList(Node node) {
        this.head = node;
    }
    public Node getHead() {
        return head;
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
        Node middle = slow;
        return true;
    }

    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeLoop(Node head, Node loopNode) {
        Node ptr1 = loopNode;
        Node ptr2 = loopNode;
        int k = 0;
        // find number of nodes in the loop.
        while(ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }
        // now move a pointer to k nodes away from head
        ptr2 = head;
        while(k>0) {
            ptr2 = ptr2.next;
            k--;
        }
        ptr1 = head;
        // move both pointers at same pace so that they meet
        while(ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // traverse and get the last node
        // if ptr2.next = ptr1 i.e. the place loop to break
        while(ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }
    public void detectAndRemoveLoop() {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println("list:");
        ll.print();
        System.out.println("After reverse");
        //ll.reverse();
        ll.reverseItr();
        ll.print();
    }
}
