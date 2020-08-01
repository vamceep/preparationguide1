package educativeio.patterns.slindingwindows;

public class MaxSumSubArrayOfSizeK {
    /**
     * Problem Statement #
     * Given an array of positive numbers and a positive number ‘k’,
     * find the maximum sum of any contiguous subarray of size ‘k’.
     *
     * Example 1:
     *
     * Input: [2, 1, 5, 1, 3, 2], k=3
     * Output: 9
     * Explanation: Subarray with maximum sum is [5, 1, 3].
     * Example 2:
     *
     * Input: [2, 3, 4, 1, 5], k=2
     * Output: 7
     * Explanation: Subarray with maximum sum is [3, 4].
     *
     *
     */

    public static int MaxSubArraySum(int[] arr, int k) {
        int start = 0;
        int sum = 0;
        int maxSum = 0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            if(i >= k-1) {
                maxSum = Math.max(sum , maxSum);
                sum  -= arr[start];
                start++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
//        int arr[] =  {2, 1, 5, 1, 3, 2};
//        int k = 3;

        int arr[] = {2, 3, 4, 1, 5};
        int k =2;
        System.out.println(MaxSubArraySum(arr,k));
    }
}
