package preparation.matrix;

public class FindBigIsLand {
    /**
     * This is related to finaIsLand problem. In this we need to return the size of biggest
     * island of all in the 2D matrix.
     * this will modify the given matrix.
     * or clone the matrix if it should not modify
     * or use visited boolean matrix.
     * https://www.youtube.com/watch?v=R4Nh-EgWjyQ
     *
     * *** This to absorb: make row column boundaries check separate if possible
     * to make code clean and avoid ambiguity.
     */


    public static int getIsLandSize(int[][] m, int row, int col) {
        if(row < 0 || row >= m.length || col < 0 || col >= m[row].length) {
            return 0;
        }
        if(m[row][col] == 0) {
            return 0;
        }
        m[row][col] = 0;
        int size = 1;
        for(int r = row -1 ; r <= row+1;r++) {
            for(int c = col-1; c <= col+1; c++) {
                if(r != row || c != col) {
                    size += getIsLandSize(m, r, c);
                }
            }
        }
        return size;
    }
    public static int findBigIsLand(int[][] m) {
        int maxIsLand = 0;
        for(int row = 0; row < m.length;row++) {
            for(int col = 0; col < m[row].length;col++) {
                if(m[row][col] == 1) {
                    int size = getIsLandSize(m, row,col);
                    maxIsLand = Math.max(size, maxIsLand);
                }
            }
        }
        return maxIsLand;
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
                { 0, 1, 1, 0 },
                { 1, 0, 0, 1 },
                { 0, 1, 0, 0 }};
        FindBigIsLand I = new FindBigIsLand();
        System.out.println("Max size of islands is: " + I.findBigIsLand(M));
    }
}
