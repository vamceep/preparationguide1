package preparation.dynamicprogramming;

public class LongestIncreasingSubSequence {
    /**
     * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
     * of a given sequence such that all elements of the subsequence are sorted in increasing order.
     * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
     * More examples:
     * Input  : arr[] = {3, 10, 2, 1, 20}
     * Output : Length of LIS = 3
     * The longest increasing subsequence is 3, 10, 20
     *
     * Input  : arr[] = {3, 2}
     * Output : Length of LIS = 1
     * The longest increasing subsequences are {3} and {2}
     *
     * Input : arr[] = {50, 3, 10, 7, 40, 80}
     * Output : Length of LIS = 4
     * The longest increasing subsequence is {3, 7, 40, 80}
     */

    public static int lis(int[] a, int n) {
        int[] lis = new int[n];

        for (int i=0; i < lis.length; i++) {
            lis[i] = 1;
        }
        for(int i = 1; i< n; i++) {
            for(int j = 0; j < i ; j++) {
                if(a[i] > a[j] && lis[i] < lis[j] +1) {
                    lis[i] = lis[j] +1;
                }
            }
        }
        int max = 0;
        for (int i=0; i < lis.length; i++) {
            if(max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
       int arr[] = {50, 3, 10, 7, 40, 80};
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n) + "\n");
    }
}
