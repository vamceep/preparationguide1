package preparation.lrucache;

public class DoublyLinkedList {

    public static class Node {
        private Node next, prev;
        public Node() {

        }
    }

    private int size = 0;
    private Node last, first;

    public void addList(Node node) {
        if(first == null) {
            first = node;
            last = first;
            size++;
            return;
        }

        size++;
        last.next = node;
        node.prev = last;
        last = node;
    }

    public Node removeFist() {
        if(first == null) {
            return null;
        }
        size--;
        Node temp = first;
        first = first.next;
        temp.next = null;
        return temp;
    }

    public void removeNodeAndAddToLast(Node node) {
        if(last == node) {
            return;
        }

        if(first == node) {
            Node temp = first;
            first = first.next;
            temp.next = null;
            addList(temp);
            return;
        }

        Node previous = node.prev;
        Node forward = node.next;

        previous.next = forward;
        forward.prev = previous;

        node.prev = null;
        node.next = null;
        addList(node);
    }
//    public String print() {
//        Node temp = first;
//        StringBuilder stringBuilder = new StringBuilder("[");
//        while (temp != null) {
//            stringBuilder.append(temp.power.getSuperHeroName() + ",");
//            temp = temp.next;
//        }
//        stringBuilder.deleteCharAt((stringBuilder.length() - 1));
//        stringBuilder.append("]\n");
//        return stringBuilder.toString();
//    }

    public int getSize() {
        return this.size;
    }
}
