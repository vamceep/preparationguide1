package preparation.dynamicprogramming;

public class NumPathsInMatrix {

    public static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int numPaths(int r, int c) {
        int[][] dp = new int[r][c];
        for (int i=0;i<r;i++) {
            dp[i][0] =1;
        }

        for(int j=0;j<c;j++) {
            dp[0][j]= 1;
        }

        for(int i=1;i<r;i++) {
            for(int j=1;j<c;j++) {
                // if we add dp[i-1][j-1] , it includes diagnol also
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        printMatrix(dp);
        return dp[r-1][c-1];
    }

    // space of O(n)
    static int numberOfPaths(int m, int n)
    {
        // Create a 1D array to store results of subproblems
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        for (int val:dp
             ) {
            System.out.print(val + " ");
        }
        System.out.println();
        return dp[n - 1];
    }
    public static void main(String[] args) {
        int row = 5;
        int col = 5;
        System.out.println("path: row:" + row + " col:" + col + " = " + numPaths(row,col));

        System.out.println("path: row:" + row + " col:" + col + " = " + numberOfPaths(row,col));
    }
}
