package preparation.arrays;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KthSmallestElementOfArray {
    /**
     * ind the kth smallest element of a given array
     */

    public static class smaller implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1.intValue() < o2.intValue() ? 1 : 0);
        }
    }
    public static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new smaller());
        for(int i=0; i<k;i++) {
            queue.add(arr[i]);
        }

        Iterator val = queue.iterator();
        while (val.hasNext()) {
            System.out.print(val.next() + " ");
        }
        System.out.println();
        for(int i=k; i<arr.length;i++) {
            if(queue.peek() > arr[i]) {
                queue.remove();
                queue.add(arr[i]);
            }
            val = queue.iterator();
            while (val.hasNext()) {
                System.out.print(val.next() + " ");
            }
            System.out.println();
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int[] arr = {15,2,5,3,20,22,30,8,10,1};
        int k = 3;
        for (int i:arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(k + " th smallest : " + kthSmallestElement(arr, k));
    }
}
