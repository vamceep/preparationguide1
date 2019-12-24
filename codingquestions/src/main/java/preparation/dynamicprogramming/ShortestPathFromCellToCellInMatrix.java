package preparation.dynamicprogramming;

public class ShortestPathFromCellToCellInMatrix {

    static class Cell {
        int row;
        int col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    /*
    https://medium.com/@tiagot/dynamic-programming-an-induction-approach-b5c5e73c4a19
    Give an n*m preparation.matrix where each cell carries weight (+ or - ve values), find the
    shortest path from [i][j] to [k][l] with minimum cost.
     */
    public static int findShortestPath(int[][] matrix, Cell left, Cell right) {
        int[][] shortestPath = new int[matrix.length][matrix[0].length];
        shortestPath[0][0] = matrix[0][0];
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=1;i<m;i++) {
            shortestPath[0][i] = shortestPath[0][i-1] + matrix[0][i];
        }
        for(int i=1;i<n;i++) {
            shortestPath[i][0] = shortestPath[i-1][0] + matrix[i][0];
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                shortestPath[i][j] = Math.min(shortestPath[i-1][j], shortestPath[i][j-1]) + matrix[i][j];
            }
        }
        printMatrix(shortestPath);

        return 0;
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
        int[][] matrix = {
                {5, 3, 2, 1, -2, 7},
                {1, 7, -3, 3, 5, 4},
                {4, 4, -2, 8, 1, -3},
                {8, -1, 7, 0, 5, 2},
                {4, 6, -3, 3, -4, 7},
                {-5, 3, -2, 6, 9, 2}
        };
        printMatrix(matrix);
        findShortestPath(matrix, new Cell(0,0), new Cell(3,3));
    }
}
