package preparation.linkedlists;

public class SwapKthNodeFromFirstandLastInLinkedList {

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
    public static void swapNodes(int front, int last) {
        if(front <=0 || last <= 0) {
            return;
        }

        if(root != null) {

            Node second = root;
            Node nodeFromLast = root;
            int c = 0;
            while(c < last) {
                if(second == null) {
                    System.out.println("last value is invalid");
                    return;
                }
                second = second.next;
                c++;
            }
            while(second != null) {
                nodeFromLast = nodeFromLast.next;
                second = second.next;
            }
            Node first = root;
            c = 0;
            while(c < front-1) {
                if(first == null) {
                    System.out.println("last value is invalid");
                    return;
                }
                first = first.next;
                c++;
            }
            int temp = nodeFromLast.val;
            nodeFromLast.val = first.val;
            first.val = temp;
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
        root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);
        root.next.next.next.next = new Node(50);
        root.next.next.next.next.next = null;
        printList();
        swapNodes(5,3);
        printList();
    }
}
