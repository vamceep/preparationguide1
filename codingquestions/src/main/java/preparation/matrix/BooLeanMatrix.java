package preparation.matrix;

public class BooLeanMatrix {
    /**
     * A Boolean Matrix Question
     * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
     * Example 1
     * The matrix
     * 1 0
     * 0 0
     * should be changed to following
     * 1 1
     * 1 0
     *
     * Example 2
     * The matrix
     * 0 0 0
     * 0 0 1
     * should be changed to following
     * 0 0 1
     * 1 1 1
     *
     * Example 3
     * The matrix
     * 1 0 0 1
     * 0 0 1 0
     * 0 0 0 0
     * should be changed to following
     * 1 1 1 1
     * 1 1 1 1
     * 1 0 1 1
     * https://www.geeksforgeeks.org/a-boolean-matrix-question/
     */

    public static void printMatrix(int mat[ ][ ], int R, int C)
    {
        int i, j;
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void modifyMatrixMethod1(int[][] mat, int r, int c) {
        int[] rows = new int[r];
        int[] cols = new int[c];

        for(int i=0;i < r; i++) {
            for(int j=0;j<c;j++) {
                if(mat[i][j] == 1) {
                    rows[i] =1;
                    cols[j] =1;
                }
            }
        }

        for(int i=0;i < r; i++) {
            for(int j=0;j<c;j++) {
                if(rows[i] == 1 || cols[j] == 1) {
                    mat[i][j] = 1;
                }
            }
        }
    }

    // without much extra space
    public static void modifyMatrixMethod2(int[][] mat, int r, int c) {
        boolean rowHasOne = false;
        boolean colHasOne = false;

        for(int i=0;i < r; i++) {
            for(int j=0;j<c;j++) {
                if(i==0 && mat[i][j] == 1) {
                    rowHasOne = true;
                }
                if(j==0 && mat[i][j] == 1) {
                    colHasOne = true;
                }

                if(mat[i][j] == 1) {
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }

        }
        for(int i=1;i < r; i++) {
            for(int j=1;j<c;j++) {
                if(mat[0][j] == 1 || mat[i][0] == 1) {
                    mat[i][j] = 1;
                }
            }
        }
        if(rowHasOne) {
            for(int i=0;i < c; i++) {
                mat[0][i] = 1;
            }
        }
        if(colHasOne) {
            for(int i=0;i < r; i++) {
                mat[i][0] = 1;
            }
        }
    }
    public static void main(String[] args)
    {
        int mat[ ][ ] = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0}
        };

        System.out.println("Matrix initially");

        printMatrix(mat, mat.length, mat[0].length);

        modifyMatrixMethod2(mat, mat.length, mat[0].length);
        System.out.println("Matrix after modification n");
        printMatrix(mat, mat.length, mat[0].length);

    }
}
