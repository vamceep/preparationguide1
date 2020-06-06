package preparation.arrays;

public class FindDuplicatesInArray {
    /**
     * Find duplicates in O(n) time and O(1) extra space | Set 1
     * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
     * Example:
     *
     * Input : n = 7 and array[] = {1, 2, 3, 1, 3, 6, 6}
     * Output: 1, 3, 6
     *
     * Explanation: The numbers 1 , 3 and 6 appears more
     * than once in the array.
     *
     * Input : n = 5 and array[] = {1, 2, 3, 4 ,3}
     * Output: 3
     *
     * Explanation: The number 3 appears more than once
     * in the array.
     * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
     *
     * Sol: for each value of a[i] i.e k, make a[k] as negative.
     * if again k finds, a[k] would be < 0 that means same number repeated more than once.
     *
     * This will modify existing array.
     *
     */

    public void printDuplicates(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[Math.abs(arr[i])] >=0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }else {
                System.out.println(Math.abs(arr[i]));
            }
        }
    }
    public static void main(String[] args) {
        FindDuplicatesInArray duplicatesInArray = new FindDuplicatesInArray();
        int arr[] = {1, 2, 3, 1, 3, 6, 6};

        duplicatesInArray.printDuplicates(arr);
    }
}
