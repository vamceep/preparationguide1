package preparation.linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    /**
     * Merge k sorted linked lists | Set 2 (Using Min Heap)
     * Given k sorted linked lists each of size n, merge them and print the sorted output.
     *
     * Examples:
     *
     * Input: k = 3, n =  4
     * list1 = 1->3->5->7->NULL
     * list2 = 2->4->6->8->NULL
     * list3 = 0->9->10->11->NULL
     *
     * Output: 0->1->2->3->4->5->6->7->8->9->10->11
     * Merged lists in a sorted order
     * where every element is greater
     * than the previous element.
     *
     * Input: k = 3, n =  3
     * list1 = 1->3->7->NULL
     * list2 = 2->4->8->NULL
     * list3 = 9->10->11->NULL
     *
     * Output: 1->2->3->4->7->8->9->10->11
     * Merged lists in a sorted order
     * where every element is greater
     * than the previous element.
     *
     * USING MIN HEAP :
     * Complexity Analysis:
     *
     * Time Complexity: O( n * k * log k).
     * Insertion and deletion in a Min Heap requires log k time. So the Overall time complexity is O( n * k * log k)
     * Auxiliary Space: O(k).
     * k is the space required to store the priority queue.
     */

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next =null;
        }
    }
    public static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static class MyCompare implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.val > o2.val ? 1:-1;
        }
    }
    public static Node mergeKSortedLists(Node[]  arr, int k) {
        Node head = null;
        Node last = null;
        PriorityQueue<Node> pq = new PriorityQueue<>(new MyCompare());
        for(int i=0; i< k;i++) {
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()) {
            Node top = pq.peek();
            pq.remove();
            if(top.next != null) {
                pq.add(top.next);
            }

            if(head == null) {
                head = top;
                last = top;
            }else {
                last.next = top;
                last = top;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        Node head = mergeKSortedLists(arr, k);
        printList(head);
    }
}
