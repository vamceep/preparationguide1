package preparation.dynamicprogramming;

public class LargestSubArrayWithTrueValues {
    /**
     * Given 2D boolean array, find the largest sub array of true values.
     * The return values should be side lenght of largest sub array.
     */

    public static int largetsBooleanArray(boolean[][] a) {
        if(a.length == 0) {
            return 0;
        }
        int max = 0;
        int m = a.length;
        int n = a[0].length;
        int[][] cache = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j< n; j++) {
                if(i==0 || j== 0) {
                    cache[i][j] = (a[i][j]) ? 1 : 0;
                }else if(a[i][j]){
                    cache[i][j] = Math.min(
                            Math.min(cache[i][j-1], cache[i-1][j]),
                            cache[i-1][j-1]) +1;
                }
                if(cache[i][j] > max) {
                    max = cache[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
//        boolean[][] matrix= {
//                {true,true,true,true,true},
//                {true,true,true,true,false},
//                {true,true,true,true,false},
//                {true,true,true,true,false},
//                {true,false,false,false,false}};
        boolean[][] matrix= {
                {true,true,true,true,true},
                {true,true,true,true,false},
                {true,true,true,true,false},
                {false,true,true,true,false},
                {true,false,false,false,false}};
        System.out.println("max sub matrix with true: " + largetsBooleanArray(matrix));
    }
}
