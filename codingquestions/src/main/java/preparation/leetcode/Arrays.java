package preparation.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Arrays {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> sumHash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (sumHash.containsKey(compliment)) {
                return new int[]{sumHash.get(compliment), i};
            } else {
                sumHash.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    /*
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
     */
    public static int subarraySum(int[] nums, int k) {

        return 0;
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /*
    rotate array by k times
     */
    public static int[] rotateArray(int[] nums, int k) {

        if (k > 0) {
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
        }
        return nums;
    }

    public static int max(int a, int b) {
        return (a > b ? a:b);
    }
    public static int max(int a, int b, int c) {
        return (max(max(a, b), c));
    }
    public static int maxCrossingSum(int[] nums, int l, int m, int r) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + nums[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }

        return (left_sum + right_sum);
    }
    /*
    maximum sub array sum:
    You are given a one dimensional array that may contain both positive and negative integers,
    find the sum of contiguous subarray of numbers which has the largest sum.
    For example, if the given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the maximum subarray
    sum is 7 (see highlighted elements)
    1) Divide the given array in two halves
    2) Return the maximum of following three
    ….a) Maximum subarray sum in left half (Make a recursive call)
    ….b) Maximum subarray sum in right half (Make a recursive call)
    ….c) Maximum subarray sum such that the subarray crosses the midpoint
     */
    public static int maxSubArraySum(int[] nums, int l, int r) {
        int maxsum = 0;
        if(l == r) {
            return nums[l];
        }
        int m = (l+r) /2;
        return max(maxSubArraySum(nums, l, m),
                maxSubArraySum(nums, m+1, r),
                maxCrossingSum(nums, l, m, r));
    }

    public static void main(String[] args) {
        //checkTwoSum();
        //checkRotateArrya();
        checkMaxSubArraySum();
    }

    public static void checkMaxSubArraySum() {
        int arr[] = {-2, -5, 6, -2, -3, 1, 5, -6};
        //int arr[] = {-2, -5, 6};
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n-1);
        System.out.println("max sub array sum: " + max_sum);
    }
    public static void checkRotateArrya() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 0;
        int[] result = rotateArray(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static void checkTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 1;
        int[] results = twoSum(nums, target);
        if (results.length > 0) {
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
        } else {
            System.out.println("no numbers found");
        }
    }
}
