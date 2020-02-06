package preparation.arrays;

public class MaxArraySubSum {

    /**
     * Size of The Subarray With Maximum Sum
     * An array is given, find length of the subarray having maximum sum.
     *
     * Examples :
     *
     * Input :  a[] = {1, -2, 1, 1, -2, 1}
     * Output : Length of the subarray is 2
     * Explanation: Subarray with consecutive elements
     * and maximum sum will be {1, 1}. So length is 2
     *
     * Input : ar[] = { -2, -3, 4, -1, -2, 1, 5, -3 }
     * Output : Length of the subarray is 5
     * Explanation: Subarray with consecutive elements
     * and maximum sum will be {4, -1, -2, 1, 5}.
     * same as : Largest Sum Contiguous Subarray
     */
    public static int maxArraySubSumWithNegativeValues(int[] arr) {
        int n = arr.length;
        int local_max = 0;
        int global_max = Integer.MIN_VALUE;
        for(int i=0;i < n;i++) {
            local_max = Math.max(arr[i], arr[i]+ local_max);
            if(local_max > global_max) {
                global_max = local_max;
            }
        }
        return global_max;
    }
    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr= {-1, -2, 3, -4};
        int res = maxArraySubSumWithNegativeValues(arr);
        System.out.println("Max sum is : " + res);
    }
}
