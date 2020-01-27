package preparation.dynamicprogramming;

public class EditDistance {

    /**
     * https://www.geeksforgeeks.org/edit-distance-dp-5/
     * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
     *
     * Insert
     * Remove
     * Replace
     * All of the above operations are of equal cost.
     *
     * Examples:
     *
     * Input:   str1 = "geek", str2 = "gesek"
     * Output:  1
     * We can convert str1 into str2 by inserting a 's'.
     *
     * Input:   str1 = "cat", str2 = "cut"
     * Output:  1
     * We can convert str1 into str2 by replacing 'a' with 'u'.
     *
     * Input:   str1 = "sunday", str2 = "saturday"
     * Output:  3
     * Last three and first characters are same.  We basically
     * need to convert "un" to "atur".  This can be done using
     * below three operations.
     * Replace 'n' with 'r', insert t, insert a
     */

    public static int editDistance(String s1, String s2, int m ,int n) {
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0) {
                    dp[i][j] = j;
                }else if(j==0) {
                    dp[i][j] = i;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1+ min(
                            dp[i][j-1],  // insert
                            dp[i-1][j],  // remove
                            dp[i-1][j-1]); // replace
                }
            }
        }
        printMatrix(dp);
        return dp[m][n];
    }
    public static void main(String[] args) {
//        String s1 = "geek";
//        String s2 = "gesek";
//        String s1 = "Sunday";
//        String s2 = "Saturday";
        String s1 = "bat";
        String s2 = "cat";
        int distance = editDistance(s1, s2, s1.length(), s2.length());
        System.out.println("Edit distance of: " + s1 + " s2 is : " + distance);
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

    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }
}
