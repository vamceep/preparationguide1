package preparation.arrays;

public class MaxArraySum {
    /**
     * https://www.hackerrank.com/challenges/max-array-sum/problem
     * Given an array of integers, find the subset of non-adjacent elements with
     * the maximum sum. Calculate the sum of that subset.
     *
     * For example, given an array  we have the following possible subsets:
     *
     * Subset      Sum
     * [-2, 3, 5]   6
     * [-2, 3]      1
     * [-2, -4]    -6
     * [-2, 5]      3
     * [1, -4]     -3
     * [1, 5]       6
     * [3, 5]       8
     * Our maximum subset sum is .
     *
     * Function Description
     *
     * Complete the  function in the editor below. It should return an integer representing
     * the maximum subset sum for the given array.
     *
     * maxSubsetSum has the following parameter(s):
     *
     * arr: an array of integers
     * Input Format
     *
     * The first line contains an integer, .
     * The second line contains  space-separated integers .
     *
     * Constraints
     *
     * Output Format
     *
     * Return the maximum sum described in the statement.
     *
     * Sample Input 0
     *
     * 5
     * 3 7 4 6 5
     * Sample Output 0
     *
     * 13
     * Explanation 0
     *
     * Our possible subsets are  and . The largest subset sum is  from subset
     *
     * Sample Input 1
     *
     * 5
     * 2 1 5 8 4
     * Sample Output 1
     *
     * 11
     * Explanation 1
     *
     * Our subsets are  and . The maximum subset sum is  from the first subset listed.
     *
     * Sample Input 2
     *
     * 5
     * 3 5 -7 8 10
     * Sample Output 2
     *
     * 15
     * Explanation 2
     *
     * Our subsets are  and . The maximum subset sum is  from the fifth subset listed.
     */

    public static int maxArraySum(int[] arr) {
        int l = arr.length;
        if(l == 0) {
            return 0;
        }
        int[] dp = new int[l];
        dp[0] = Math.max(0,arr[0]);
        if(l == 1) {
            return dp[0];
        }
        dp[1] = Math.max(dp[0], arr[1]);
        if(l == 2) {
            return dp[1];
        }
        for(int i = 2;i<l;i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-2] + arr[i]));
        }
        return Math.max(dp[l-1],dp[l-2]);
    }
    public static void main(String[] args) {
        int[] arr = {3,5,-7,8,10};
        int ret = maxArraySum(arr);
        System.out.println("Max array sum: " + ret);
    }
}
