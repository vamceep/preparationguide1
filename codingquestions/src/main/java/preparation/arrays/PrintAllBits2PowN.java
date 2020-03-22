package preparation.arrays;

import java.util.Arrays;

public class PrintAllBits2PowN {
    /**
     * Given n print all bits of 2 ^ n
     * i.e if n = 3 print 000, 001, 010, 010, 011, 100, 101, 110, 111
     */
    public static void printAllBitCombinations(int n) {
        int max = 1 << n ; // give 2 ^ n;
        int[] digits = new int[n];
        for(int i = 0; i<max;i++) {
            int index = 0;
            Arrays.fill(digits, 0);
            for(int j=i ; j > 0 ; j >>= 1) {
                if((j & 1) == 1) {
                    digits[n-index-1] =1;
                }
                index++;
            }
            for( int k : digits) {
                System.out.print(k + "");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        printAllBitCombinations(n);
    }
}
