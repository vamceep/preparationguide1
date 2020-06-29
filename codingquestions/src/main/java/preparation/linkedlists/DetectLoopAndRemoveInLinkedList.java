package preparation.linkedlists;

public class DetectLoopAndRemoveInLinkedList {
    /**
     * Detect and remove loop in linked list
     *
     * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
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

    public static void removeLoop() {
        if(root == null || root.next == null) {
            return;
        }
        Node slow = root.next;
        Node fast = root.next.next;
        while (fast != null || fast.next != null) {
            if(slow == fast) {
                System.out.println("Found a loop in the list");
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == fast) {
            slow = root;
            while(slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }
    public static void printList() {
        Node temp = root;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        addToList(50);
        addToList(20);
        addToList(15);
        addToList(4);
        addToList(10);
        // if loop is to root i.e root.next.next.next.next.next = root, it is not working
        // TODO ...
        root.next.next.next.next.next = root.next;
        removeLoop();
        printList();
    }
}
