package preparation.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    /**
     *  Given an array of integers, nums and a target value T, find the number of
     *  * ways that you can add and subtract the values in nums to add up to T.
     *  *
     *  * eg.
     *  * nums = {1, 1, 1, 1, 1}
     *  * target = 3
     *  *
     *  * 1 + 1 + 1 + 1 - 1
     *  * 1 + 1 + 1 - 1 + 1
     *  * 1 + 1 - 1 + 1 + 1
     *  * 1 - 1 + 1 + 1 + 1
     *  * -1 + 1 + 1 + 1 + 1
     *  Operations: subtraction , addition
     */

    public static int naiveTargetSum(int[] a, int target) {
        return naiveTargetSum(a, target, 0, 0);
    }

    public static int naiveTargetSum(int[] a, int target, int index, int currentSum) {
        if(a.length == index) {
            return (target == currentSum) ? 1:0;
        }

        return naiveTargetSum(a, target, index+1, currentSum + a[index])
                + naiveTargetSum(a, target, index+1, currentSum-a[index]);
    }


    // top down approach
    // will have a map of index to <sum, count>

    public static int topDownTargetSum(int[] a, int target) {
        HashMap<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return topDownTargetSum(a, target, 0, 0, cache);
    }

    private static int topDownTargetSum(int[] a, int target, int i, int currentSum, HashMap<Integer, Map<Integer, Integer>> cache) {
        if(a.length == i) {
            return (target == currentSum) ? 1:0;
        }

        if(!cache.containsKey(i)) {
            cache.put(i, new HashMap<>());
        }
        Integer value = cache.get(i).get(currentSum);
        if(value != null) {
            return value;
        }
        int updateVal = topDownTargetSum(a, target, i+1, currentSum + a[i], cache)
                + topDownTargetSum(a, target, i+1, currentSum - a[i], cache);
        cache.get(i).put(currentSum, updateVal);
        return updateVal;
    }

    // bottom up approach
    // since there is subtraction, sum can rage between -sum and +sum for caching
    public static int bottomUpTargetSum(int[] a, int target) {
        int sum = 0;
        for(int num : a) {
            sum += num;
        }
        int[][] cache = new int[a.length+1][2*sum +1];
        if(sum == 0) {
            return 0;
        }
        // int i = 0, target = 0;
        cache[0][sum] =1;
        for(int i = 1; i<= a.length; i++) {
            for(int j = 0; j< 2 * sum * 1; j++) {
                int prev = cache[i-1][j];
                if(prev != 0) {
                    cache[i][j- a[i-1]] += prev;
                    cache[i][j- a[i-1]] += prev;
                }
            }
        }
        return cache[a.length][sum+target];
    }

    // Sample testcases
    public static void main(String[] args) {
        (new TestCase(new int[]{}, 1, 0)).run();
        (new TestCase(new int[]{1, 1, 1, 1, 1}, 3, 5)).run();
        (new TestCase(new int[]{1, 1, 1}, 1, 3)).run();
        System.out.println("Passed all test cases");
    }

    // Class for defining and running test cases
    private static class TestCase {
        private int[] nums;
        private int target;
        private int output;

        private TestCase(int[] nums, int target, int output) {
            this.nums = nums;
            this.target = target;
            this.output = output;
        }

        private void run() {
            assert naiveTargetSum(nums, target) == output:
                    "naiveTargetSum failed for nums = " + Arrays.toString(nums) + ", target = " + target;
            assert topDownTargetSum(nums, target) == output:
                    "topDownTargetSum failed for nums = " + Arrays.toString(nums) + ", target = " + target;
            assert bottomUpTargetSum(nums, target) == output:
                    "bottomUpTargetSum failed for nums = " + Arrays.toString(nums) + ", target = " + target;
        }
    }
}
