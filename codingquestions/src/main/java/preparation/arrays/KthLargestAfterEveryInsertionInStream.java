package preparation.arrays;

import preparation.leetcode.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestAfterEveryInsertionInStream {
    /**
     * Find the kth largest element from the stream of input numbers
     * https://www.geeksforgeeks.org/kth-smallest-element-after-every-insertion/?ref=rp
     *
     */
    public static class greater implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1.intValue() > o2.intValue() ? 1 : 0);
        }
    }
    public static int KthLargestElement(int[] arr, int k) {
        int ret = 0;
        PriorityQueue<Integer> queue = new PriorityQueue();

        for(int i = 0; i < k;i++) {
            queue.add(arr[i]);
        }
        for(int i = k ;i < arr.length;i++) {
            int val = queue.peek().intValue();
            if(arr[i] > val) {
                queue.remove();
                queue.add(arr[i]);
            }
        }
        return queue.peek().intValue();
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 11, 50, 80, 40, 100, 55};
        int k = 3;
        for (int i:arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int res = KthLargestElement(arr, k);
        System.out.println(k + " largest: " + res);
    }
}
