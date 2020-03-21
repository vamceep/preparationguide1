package preparation.matrix;

public class FindIsLands {
    /**
     * Give a matrix of 0 and 1 find the Islands with 1.
     * https://www.geeksforgeeks.org/find-number-of-islands/
     *(not disjoing sets)
     * Ex:
     * Input : mat[][] = {{1, 1, 0, 0, 0},
     *                    {0, 1, 0, 0, 1},
     *                    {1, 0, 0, 1, 1},
     *                    {0, 0, 0, 0, 0},
     *                    {1, 0, 1, 0, 1}
     * Output : 5
     */
    static int R;
    static int C;

    public static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        // if given row col is falling under the range, visited is not true, and matrix has 1
        return (row >= 0) && (row < R) && (col >= 0) && (col < C)
                && (M[row][col] == 1) && (!visited[row][col]);
    }
    public static void dfs(int[][] M, int row, int col, boolean[][] visited){
        // at M[i][j] possible traversals in all directions
        int[] rowIndex  = {-1,-1,-1,0,0,1,1,1};
        int[] colIndex = {-1,0, 1,-1,1,-1,0,1};
        visited[row][col] = true;
        for(int k = 0; k < 8;k++) {
            if(isSafe(M, row + rowIndex[k], col+colIndex[k], visited)) {
                dfs(M,row + rowIndex[k], col+colIndex[k], visited);
            }
        }
    }

    public static int countIslands(int[][] M) {
        boolean[][] visited = new boolean[R][C];
        int count = 0;
        for(int i = 0; i< R; i++) {
            for(int j = 0; j< C;j++) {
                if(M[i][j] == 1 &&  !visited[i][j]) {
                    dfs(M,i,j,visited);
                    ++count;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws java.lang.Exception
    {

//        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
//                { 0, 1, 0, 0, 1 },
//                { 1, 0, 0, 1, 1 },
//                { 0, 0, 0, 0, 0 },
//                { 1, 0, 1, 0, 1 } };
        int M[][] = new int[][] {
                { 1, 1, 0, 1 },
                { 0, 0, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 1, 0, 0 }};
        R = M.length;
        C = M.length;
        FindIsLands I = new FindIsLands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
