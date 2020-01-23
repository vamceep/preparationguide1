package preparation.arrays;

public class ArrayProblems {

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if(low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if(arr[mid] == key) {
            return mid;
        }
        if(arr[mid] > key) {
            return binarySearch(arr, low, mid-1, key);
        }
        return binarySearch(arr, mid+1, high, key);
    }
    public static int findPivot(int arr[], int low, int high) {
        // base case
        if(high < low) {
            return -1;
        }
        if(high == low) {
            return high; // or low
        }
        int mid = (low + high) /2;
        if(mid < high && arr[mid] > arr[mid + 1]){
            return mid;
        }
        if(mid > low && arr[mid] < arr[mid -1]) {
            return (mid -1);
        }
        if(arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid-1);
        }
        return findPivot(arr, mid+1, high);
    }

    // Expects a sorted array
    /*
    Hint: pivot element where the next element to it will be smaller
    i.e 3 4 5 1 2 and pivot is 5.
    idea is find pivot and call binary search on both arrays
     */
    public static int searchInRotatedSortedArray(int[] arr, int val) {
        int pivot = findPivot(arr, 0, arr.length-1);
        if(pivot == -1) {
            return -1;
        }
        if(arr[pivot] == val) {
            return pivot;
        }
        if(arr[0] <= val) {
            return binarySearch(arr,0, pivot-1, val);
        }
        return binarySearch(arr, pivot+1, arr.length-1, val);
    }

    public static int search(int[] arr, int low, int high, int val) {
        if(low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if(arr[mid] == val) {
            return mid;
        }
        /* if arr[low ... mid] sorted */
        if(arr[low] <= arr[mid]) {
            if (val >= arr[low] && val <= arr[mid]) {
                return search(arr, low, mid-1, val);
            }
            return search(arr, mid+1, high, val);
        }
        if(val >= arr[mid] && val <= arr[high]) {
            return search(arr, mid+1, high, val);
        }
        return search(arr, low, mid-1, val );
    }
    public static int searchRotatedSortedArrayImproved(int[] arr, int val) {
        return search(arr, 0, arr.length, val);
    }
    public static void main(String[] args) {
        int[] arr= {4,5,6,7,1,2,3};
        System.out.println("index: " + searchRotatedSortedArrayImproved(arr, 4));
    }
}
