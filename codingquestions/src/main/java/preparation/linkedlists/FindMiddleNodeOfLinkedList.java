package preparation.linkedlists;

public class FindMiddleNodeOfLinkedList {
    /**
     * Find the mille node of a given linked list
     */

    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static Node root;
    public static void printList() {
        Node temp = root;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void findMiddle() {
        if(root != null) {
            Node slow = root;
            Node fast = root;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println(slow.val);
        }
    }
    public static void main(String[] args) {
        root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);
//        root.next.next.next.next = new Node(50);
        root.next.next.next.next = null;
        printList();
        findMiddle();
    }
}
