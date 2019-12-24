package preparation.heap;

public class Heap {

    public static void heapify(int[] arr, int n, int i) {
        int larget = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[larget]) {
            larget = left;
        }
        if (right < n && arr[larget] < arr[right]) {
            larget = right;
        }
        if (larget != i) {
            int temp = arr[i];
            arr[i] = arr[larget];
            arr[larget] = temp;
            // heapify the impacted sub tree since existing element is
            // replaced with a different value
            heapify(arr, n, larget);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // ascending order...
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // ascending order...
        int i = n - 1;
        int index = k;
        while (index > 0) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
            index--;
            i--;
        }
        return arr[n - k];
    }

    public static void checkforKthLarge() {
        int[] arr = {2, 250, 3, 12, 5, 8, 15, 1};
        System.out.println("Before sort, array: ");
        printArray(arr);
        for (int i = 1; i <= arr.length; i++) {
            System.out.println(" largest: " + i + " is: " + kthLargest(arr, i));
        }
    }

    public static void checkHeapSortCode() {
        int[] arr = {2, 250, 3, 12, 5, 8, 15, 1};
        System.out.println("Before sort, array: ");
        printArray(arr);
        heapSort(arr);
        System.out.println("\nAfter sort, array: ");
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        checkHeapSortCode();
        checkforKthLarge();
    }

}
