package preparation.linkedlists;

public class LinkedListApp {

    public static void main(String[] args) {
        checkLoopFunctions();
    }

    public static void checkLoopFunctions() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = node.next;
        LinkedList linkedList = new LinkedList(node);
        System.out.println("Loop : " + linkedList.detectLoop());
        linkedList.detectAndRemoveLoop();
        linkedList.print();

    }
    public static void checkReverseFunctions() {
        int[] nums = {1,2,3,4,5};
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            linkedList.add(nums[i]);
        }
        linkedList.print();
        linkedList.reverse();
        linkedList.print();
        linkedList.reverseItr();
        linkedList.print();
    }

}
