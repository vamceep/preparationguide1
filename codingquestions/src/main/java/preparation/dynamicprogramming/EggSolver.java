package preparation.dynamicprogramming;

import java.util.Arrays;

public class EggSolver {

    /**
     * Given n flooers and e eggs, find minimum number of ways from which floor eggs
     * can't break
     * need to find the floor with minimum number of eggs
     * https://www.youtube.com/watch?v=o_AJ3VWQMzA&t=863s
     */
    public  int solveUsingDp(int n, int k) {
        final int dp[][] = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][1] = i;
        }

        for (int i = 0; i < k + 1; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < k + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x < i; x++) {
                    int temp = Math.max(dp[i - x][j], dp[x - 1][j - 1]) + 1;
                    if (temp < dp[i][j]) {
                        dp[i][j] = temp;
                    }
                }

            }
        }
        for (final int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        return dp[n][k];
    }
    public static void main(String[] args) {
        System.out.println(new EggSolver().solveUsingDp(8, 4));
    }
}
