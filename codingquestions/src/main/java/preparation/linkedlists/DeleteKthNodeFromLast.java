package preparation.linkedlists;

public class DeleteKthNodeFromLast {
    /**
     * Given a linked list delete kth node from last
     */

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    };

    public static Node deleteKthNodeFromLast(Node root, int k) {
       Node first = root;
       Node second = root;
       for(int i=0;i<k;i++) {

           // if k is count of nodes
           if(second.next == null) {
               if(i== k-1) {
                   root = root.next;
                   return root;
               }
           }
           second =second.next;
       }
       while(second.next != null) {
           first = first.next;
           second = second.next;
       }
       first.next = first.next.next;
       return root;
    }

    public static void print(Node head) {
        Node tNode = head;
        while(tNode != null) {
            System.out.print(" " + tNode.val);
            tNode = tNode.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node result = deleteKthNodeFromLast(node, 4);
        print(result);
    }
}
