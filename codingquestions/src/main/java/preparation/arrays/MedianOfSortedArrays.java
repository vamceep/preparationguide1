package preparation.arrays;

public class MedianOfSortedArrays {
    /**
     * Given two sorted array find the median.
     * can be done in O(lon n)
     */

    public static double medianOfSorted(int[] a, int[] b, int starta, int startb, int enda, int endb) {
        // if only 2 elements are there in the array
        if(enda - starta  == 1) {
            return (double)((Math.max(a[starta], b[startb])
                    + Math.min(a[enda], b[endb]) )/ 2);
        }
        // get median of first array
        double m1 = median(a, starta, enda);
        // get median of second array
        double m2 = median(b, startb, endb);
        if(m1 == m2) {
            // found median
            return m1;
        }else if(m1 > m2) {
            // median will be in first half of first array and second half of second array
            // a[... m2] and b[m2...]
            return medianOfSorted(a, b, starta,(endb + startb +1 )/2,
                    (enda + starta + 1) /2, endb);
        }else {
            // median will be in second half of first array and first half of second array
            // m1 < m2
            // a[m1.....] and b[... m2]
            return medianOfSorted(a, b, (starta + enda + 1) /2, startb,
                    enda, (endb + startb + 1) /2);
        }

    }

    /*
    get median of sorted array.
     */
    public static double median(int[] arr, int start, int end) {
        int m = (end - start + 1);
        if (m % 2 == 0) {
            return (double) (arr[start + (m / 2)] + arr[start + (m / 2 - 1)]) / 2;
        } else {
            return arr[start + (m / 2)];
        }
    }


    public static void main(String[] args) {
//        int[] a1 = {2, 8, 10, 15, 20};
//        int[] a2 = {3, 4, 10, 11, 15, 16};
        int ar1[] = { 1, 2, 3, 6 };
        int ar2[] = { 4, 6, 8, 10 };
        System.out.println("median : " + medianOfSorted(ar1,ar2, 0,0, ar1.length-1, ar2.length-1));
    }
}
