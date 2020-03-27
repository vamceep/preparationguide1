package preparation.arrays;

public class SortToSquareOfArray {
    /**
     * Given a array of both positive and negative integers ‘arr[]’ which are sorted. Task is to
     * sort square of the numbers of the Array.
     * Examples:
     *
     * Input  : arr[] =  {-6, -3, -1, 2, 4, 5}
     * Output : 1, 4, 9, 16, 25, 36
     *
     * Input  : arr[] = {-5, -4, -2, 0, 1}
     * Output : 0, 1, 4, 16, 25
     *
     *
     * https://www.geeksforgeeks.org/sort-array-converting-elements-squares/
     */

    public static int[] sortSquares(int[] a) {
        int[] t = new int[a.length];
        int k = 0;
        for(k = 0; k < a.length; k++) {
            if(a[k] >= 0) {
                break;
            }
        }

        int i = k-1;
        int j = k;
        int ind = 0;

        while(i >= 0 && j < a.length) {
            if(a[i] * a[i] < a[j] * a[j]) {
                t[ind] = a[i] * a[i];
                i--;
            }else {
                t[ind] =  a[j] * a[j];
                j++;
            }
            ind++;
        }
        while(i >= 0) {
            t[ind] = a[i] * a[i];
            i--;
        }
        while(j<a.length) {
            t[ind] =  a[j] * a[j];
            j++;
        }
        return t;
    }

    public static int[] sortSquaresMethod2(int[] a) {
        int[] t = new int[a.length];
        int i = 0;
        int j = a.length -1;
        int ind = a.length -1;
        while(i < j) {
            int isqr = a[i] * a[i];
            int jsqr = a[j] * a[j];
            if(isqr < jsqr) {
                t[ind--] = jsqr;
                j--;
            }else if(isqr > jsqr) {
                t[ind--] = isqr;
                i++;
            }else {
                t[ind--] = jsqr;
                t[ind--] = isqr;
                j--;
                i++;
            }
        }

        return t;
    }
    public static void main(String[] args) {
//        int arr[] = { -6 , -3 , -1 ,0,0, 2 , 4 , 5 };
        int arr[] = {-20, -15, -10, -2, 1, 2, 40};
        int n = arr.length;

        System.out.println("Before sort ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        int[] result = sortSquaresMethod2(arr);
        System.out.println("");
        System.out.println("After Sort ");
        for (int i = 0 ; i < n ; i++)
            System.out.print(result[i] + " ");
    }
}
