package preparation.linkedlists;

public class LinkedListApp {
    public static void main(String[] args) {

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
