package preparation.sorting;

public class InsertionSort {
    /**
     * Implement insertion sort
     */

    public static void insertionSort(int[] arr) {
        for(int i=1;i <=arr.length-1;i++) {
            int v = arr[i];
            int j = i;
            while(j >= 1 && arr[j-1] > v) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr= {15,5,10,1,3,12};
        insertionSort(arr);
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
