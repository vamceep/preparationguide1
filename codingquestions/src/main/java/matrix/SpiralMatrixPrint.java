package matrix;

import java.util.ArrayList;

public class SpiralMatrixPrint {

    public static ArrayList<Integer> spiralOrderMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix == null || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while(m > 0 && n > 0) {
            // if one row/ column left, no circle can be formed
            if(m==1) {
                // only one row. so add all elements of the row
                for(int i=0 ;i < n;i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1) {
                //only one column. so add all elements
                for(int i=0; i<m;i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            // process the circle

            //top -> moving left to right
            for(int i=0; i<n-1;i++) {
                result.add(matrix[x][y++]);
            }
            // right -> move towards down
            for(int i=0;i<m-1;i++) {
                result.add(matrix[x++][y]);
            }
            // bottom -> move right to left
            for(int i=0;i <n-1;i++) {
                result.add(matrix[x][y--]);
            }
            //left -> move bottom to top
            for(int i=0; i<m-1;i++) {
                result.add(matrix[x--][y]);
            }
            x++;
            y++;
            m = m-2;
            n= n-2;
        }
        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0; j<matrix[0].length;j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                {5,6,7},
                {9,10,11}};
        printMatrix(matrix);
        ArrayList<Integer> result = spiralOrderMatrix(matrix);
        result.forEach((val) ->{
            System.out.print(" " + val);
        });
    }
}
