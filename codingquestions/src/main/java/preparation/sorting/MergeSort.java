package preparation.sorting;

public class MergeSort {
    public static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0;
        int c[] = new int[a.length + b.length];
        int k = 0;
        while(i < a.length && j < b.length ) {
            if(a[i] < b[j]) {
                c[k++] = a[i++];
            }else if(a[i] > b[j]) {
                c[k++] = b[j++];
            }else {
                c[k++] = a[i++];
                c[k++] = b[j++];
            }
        }

        if(i < a.length) {
            while(i < a.length){
                c[k++] = a[i++];
            }
        }
        if(j < b.length) {
            while (j < b.length) {
                c[k++] = b[j++];
            }
        }
        return c;
    }

    public void merge(int arr[], int left, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - left + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public  void sort(int[] arr, int l, int r) {
        if(l < r) {
            int m  = (l+r) /2 ;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr,l, m, r);
        }
    }


    public static void printArray(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a= {1,2,12,15};
        int[] b = {2,4,9,13,14};
        int[] result = merge(a,b);
        printArray(result);

        int arr1[] = {12, 11, 13, 5, 6, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr1, 0, arr1.length-1);
        printArray(arr1);
    }
}
