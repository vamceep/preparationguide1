package preparation.arrays;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
    /**
     * Given K sorted arrays, merge all of them.
     * Each array size can be DIFFERENT LENGTH.
     *
     * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
     * https://www.byte-by-byte.com/mergekarrays/?utm_source=optin_carrot&utm_medium=pdf&utm_campaign=50questions
     */


    private static class QueueNode implements Comparable<QueueNode> {
        int element;
        int array;
        int arrindex;
        public QueueNode(int element, int array, int arrindex) {
            this.element = element;
            this.array = array;
            this.arrindex = arrindex;
        }
        @Override
        public int compareTo(QueueNode o) {
            if(element > o.element) {
                return 1;
            }
            if(element < o.element) {
                return -1;
            }
            return 0;
        }
    }

    public static int[] mergeKSortedArrays(int[][] arrays) {
        int totalSize = 0;
        PriorityQueue pq = new PriorityQueue<QueueNode>();
        for(int i =0 ;i < arrays.length;i++) {
            totalSize += arrays[i].length;
            if(arrays[i].length > 0) {
                pq.add(new QueueNode(arrays[i][0],i,0));
            }
        }
        int[] result = new int[totalSize];
        for(int i =0; !pq.isEmpty();i++) {
            QueueNode node = (QueueNode) pq.poll();
            result[i] = node.element;
            int newIndex = node.arrindex +1;
            if(newIndex < arrays[node.array].length) {
                pq.add(new QueueNode(arrays[node.array][newIndex], node.array, newIndex));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000, 2500}};

        System.out.println("Merged array is :");
        int[] result = mergeKSortedArrays(arr);
        for(int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
