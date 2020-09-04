package preparation.leetcode;

public class MaxAreaOfIceLand {
    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     *
     * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
     *
     * Example 1:
     *
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
     * Example 2:
     *
     * [[0,0,0,0,0,0,0,0]]
     * Given the above grid, return 0.
     * Note: The length of each dimension in the given grid does not exceed 50.
     *
     * https://leetcode.com/problems/max-area-of-island/
     */

    public static int r = 0;
    public static int c = 0;
    public static int count = 0;
    public static int numIceLands = 0;

    public static boolean isSafe(int[][] M, int row, int col, boolean[][] visite) {
        return ((row >= 0) && (row < r) && (col >= 0) && (col < c) && (M[row][col] == 1 && !visite[row][col]));
    }

    public static void dfs(int[][] M, int row, int col, boolean[][] visited) {
        int[] rowNr = {-1,0,0,1};
        int[] colNr = {0,-1,1,0};
        visited[row][col] = true;
        for(int i= 0; i< 4;i++) {
            if(isSafe(M, row + rowNr[i], col + colNr[i], visited)) {
                count++;
                dfs(M, row+rowNr[i], col+colNr[i], visited);
            }
        }
    }

    public static void dfsAllDirections(int[][] M, int row, int col, boolean[][] visited) {
        int[] rowNr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colNr = { -1, 0, 1, -1, 1, -1, 0, 1 };
        visited[row][col] = true;
        for(int i= 0; i< rowNr.length;i++) {
            if(isSafe(M, row + rowNr[i], col + colNr[i], visited)) {
                count++;
                dfs(M, row+rowNr[i], col+colNr[i], visited);
            }
        }
    }

    public static int findMaxAreaOfIceLand(int[][] M) {
        boolean[][] visited = new boolean[r][c];
        int result = 0;
        for(int i=0; i< r;i++) {
            for(int j=0;j<c;j++) {
                if(M[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(M,i,j,visited);
                    numIceLands++;
                }
                result = Math.max(result, count);

            }
        }
        System.out.println("Num icelands: " + numIceLands);
        return result;
    }

    public static void main(String[] args) {
//        int[][] M = {
//                 {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                 {0,0,0,0,0,0,0,1,1,0,0,0,0}};

//        int M[][] = {
//                { 0, 0, 1, 1, 0 },
//                { 1, 0, 1, 1, 0 },
//                { 0, 1, 0, 0, 0 },
//                { 0, 0, 0, 0, 1 } };

//        int[][] M = {
//                {1,1,0,0,0},
//                {1,1,0,0,0},
//                {0,0,0,1,1},
//                {0,0,0,1,1}};

//        int[][] M = {
//                    {1,1,1,1,0},
//                    {1,1,0,1,0},
//                    {1,1,0,0,0},
//                    {0,0,0,0,0}};

        int[][] M = {
                      {1,1,0,0,0},
                      {1,1,0,0,0},
                      {0,0,1,0,0},
                      {0,0,0,1,1}
                    };
        r = M.length;
        c= M[0].length;
        System.out.println(findMaxAreaOfIceLand(M));
    }
}
