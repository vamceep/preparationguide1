package preparation.sorting;

public class QuickSort {
    /**
     * https://www.geeksforgeeks.org/java-program-for-quicksort/
     * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions
     * the given array around the picked pivot. There are many different versions of quickSort that pick
     * pivot in different ways.
     *
     * Always pick first element as pivot.
     * Always pick last element as pivot (implemented below)
     * Pick a random element as pivot.
     * Pick median as pivot.
     * The key process in quickSort is partition(). Target of partitions is, given an array and
     * an element x of array as pivot, put x at its correct position in sorted array and put all
     * smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x.
     * All this should be done in linear time.
     */
//    Pseudo Code for recursive QuickSort function :
//
//    /* low  --> Starting index,  high  --> Ending index */
//    quickSort(arr[], low, high)
//    {
//        if (low < high)
//        {
//        /* pi is partitioning index, arr[p] is now
//           at right place */
//            pi = partition(arr, low, high);
//
//            quickSort(arr, low, pi - 1);  // Before pi
//            quickSort(arr, pi + 1, high); // After pi
//        }
//    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l -1;
        for(int j =l; j < r; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }
    public static void sort(int[] arr, int l, int r) {
        if(l < r) {
            int pi = partition(arr, l, r);
            sort(arr, l, pi-1);
            sort(arr, pi+1, r);
        }
    }
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
