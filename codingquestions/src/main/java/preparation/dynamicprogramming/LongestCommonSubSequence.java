package preparation.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubSequence {
    /**
     * Longest Common Subsequence | DP using Memoization
     * Given two strings s1 and s2, the task is to find the length of longest common subsequence present in both of them.
     *
     * Examples:
     *
     * Input: s1 = “ABCDGH”, s2 = “AEDFHR”
     * Output: 3
     * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
     *
     *
     *
     * Input: s1 = “striver”, s2 = “raj”
     * Output: 1
     * https://www.geeksforgeeks.org/longest-common-subsequence-dp-using-memoization/
     */

    public static int longestCommonSubSequenceLength(String x, String y, int m, int n, int[][] dp) {
        if(m==0 || n==0) {
            return 0;
        }

        if(dp[m-1][n-1]!= -1) {
            return dp[m-1][n-1];
        }
        if(x.charAt(m-1) == y.charAt(n-1)) {
            dp[m-1][n-1] = 1 + longestCommonSubSequenceLength(x, y, m-1, n-1, dp);
            return dp[m-1][n-1];
        }else {
            dp[m-1][n-1] = Math.max(longestCommonSubSequenceLength(x,y, m, n-1, dp),
                    longestCommonSubSequenceLength(x,y,m-1,n,dp));
            return dp[m-1][n-1];
        }
    }

    public static int lognestCSSL(String x, String y, int m, int n) {
        int[][]dp = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 ) {
                    dp[0][j] = 0;
                }else if(j == 0) {
                    dp[i][0] = 0;
                }else if(x.charAt(i) == y.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        printMatrix(dp);
        return dp[m-1][n-1];
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int max = 10000;
        String x = "AGGTAB";
        String y = "GXTXAYB";
//        String x = "abbcb";
//        String y = "acdebbec";
//        String x = "ABCDEF";
//        String y = "FBDAMN";
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m][n];
        // assign -1 to all positions
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("lcss length: " + longestCommonSubSequenceLength(x, y, m,n,dp));
        printMatrix(dp);
        System.out.println("lcss length: " + lognestCSSL(x, y, m,n));
    }
}
