package preparation.linkedlists.dll;

public class InsertToSortedLinedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        DoublyLinkedListNode temp = head;
        DoublyLinkedListNode prev = null;
        while (temp != null) {
            if (temp.data > newNode.data) {
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            prev.next = newNode;
            newNode.prev = prev;
        }else if (prev == null) {
            newNode.next = temp;
            temp.prev = newNode;
            head = newNode;
        } else {
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = temp;
            temp.prev = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedListNode head = null;
        head = sortedInsert(head, 1);
        head = sortedInsert(head, 4);
        head = sortedInsert(head, 1);
        printDoublyLinkedList(head);
    }
}