package preparation.backtracking;

public class NQueenProblem {

    public  void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0; j<matrix[0].length;j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isSafe(int[][] b, int r, int c, int n) {
        for(int i=0;i<c;i++) {
            if(b[r][i] == 1) {
                return false;
            }
        }
        for(int i=r, j=c; i>=0 && j>=0;i--, j--) {
            if(b[i][j] == 1) {
                return false;
            }
        }
        for(int i=r, j=c; j>=0 && i<n;j--,i++) {
            if(b[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public boolean solveNQUtil(int[][] b, int c, int n) {
        if(c >= n) {
            return true;
        }
        for(int i=0; i<n;i++) {
            if(isSafe(b, i, c, n) == true) {
                b[i][c] = 1;
                if(solveNQUtil(b, c+1, n) == true) {
                    return true;
                }
                b[i][c] = 0; // back tracking.
            }
        }
        return false;
    }

    public void solve(int n) {
        int[][] b = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                b[i][j] = 0;
            }
        }
        System.out.println();
        if(solveNQUtil(b, 0, n)) {
            printMatrix(b);
        }else {
            System.out.println("Unable to place all queens");
        }
    }
    public static void main(String[] args) {
        NQueenProblem nQueenProblem = new NQueenProblem();
        nQueenProblem.solve(5);
    }
}
