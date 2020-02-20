package preparation.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * two sum set1 : (un sorted array)
     * Given an array if integers, find two numbres such that they add up to a specific target
     * function should return indices of two numbers
     */

    /**
     * using hash table with O(n) run time and O(n) space (for non sorted array)
     */

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ;i < arr.length;i++) {
            int x = arr[i];
            if(map.containsKey(target - x)) {
                return new int[] {map.get(target -x) + 1, i+1};
            }
            map.put(x,i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * for sorted array O(n) runtime and O(1) space
     * using two pointers
     */
    public static int[] twoSumOfSortedArray(int[] arr, int target) {
        // assuming input array is already sorted...
        int start = 0;
        int end = arr.length -1;
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(sum < target) {
                start++;
            }else if(sum > target) {
                end--;
            }else {
                return new int[] {start+1, end+1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        int arr[] = {5,3,1,6,2};
        int target = 11;
        try {
            int[] res = twoSum(arr, target);
            System.out.println("pair: [" + res[0] + "," + res[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println("No pair found");
        }

        int arrS[] = {1,2,3,5,6};
        target = 10;
        try {
            int[] res = twoSumOfSortedArray(arrS, target);
            System.out.println("pair: [" + res[0] + "," + res[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println("No pair found");
        }
    }
}
