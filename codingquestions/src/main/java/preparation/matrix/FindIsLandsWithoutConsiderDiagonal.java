package preparation.matrix;

public class FindIsLandsWithoutConsiderDiagonal {
    /**
     * Count number of islands where every island is row-wise and column-wise separated
     * Given a rectangular matrix which has only two possible values ‘X’ and ‘O’. The values ‘X’ always appear
     * in form of rectangular islands and these islands are always row-wise and column-wise separated by at least
     * one line of ‘O’s. Note that islands can only be diagonally adjacent. Count the number
     * of islands in the given matrix
     *
     * https://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/?ref=rp
     *
     * mat[M][N] =  {{'O', 'O', 'O'},
     *               {'X', 'X', 'O'},
     *               {'X', 'X', 'O'},
     *               {'O', 'O', 'X'},
     *               {'O', 'O', 'X'},
     *               {'X', 'X', 'O'}
     *              };
     * Output: Number of islands is 3
     *
     * mat[M][N] =  {{'X', 'O', 'O', 'O', 'O', 'O'},
     *               {'X', 'O', 'X', 'X', 'X', 'X'},
     *               {'O', 'O', 'O', 'O', 'O', 'O'},
     *               {'X', 'X', 'X', 'O', 'X', 'X'},
     *               {'X', 'X', 'X', 'O', 'X', 'X'},
     *               {'O', 'O', 'O', 'O', 'X', 'X'},
     *              };
     * Output: Number of islands is 4
     *
     * **** NOTE: this problem doesn't consider if 'X' is diagonally present.
     *          will treat it as separate entry. only left , right , bottom and top.
     */

    public static int countIslands(int[][] m) {
        int count = 0;
        for(int i=0; i < m.length; i++) {
            for(int j=0; j < m[0].length; j++) {
                if(m[i][j] == 'X') {
                    /**
                     * i == 0 and j== 0 are to check the boundaries
                     * [i-1][j] is to check for one above and m[i][j-1] is to check
                     * same row, prev cell
                     *
                     */
                    if((i==0 || m[i-1][j] == 'O') && (j==0 || m[i][j-1] == 'O') ) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

        int mat[][] = {{'O', 'O', 'O'},
                {'X', 'X', 'O'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'}
        };
        System.out.println("Number of rectangular islands is: " + countIslands(mat));
    }
}
