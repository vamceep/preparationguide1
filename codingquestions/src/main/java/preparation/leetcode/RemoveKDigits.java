package preparation.leetcode;

public class RemoveKDigits {
    /**
     * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
     *
     * Note:
     * The length of num is less than 10002 and will be ≥ k.
     * The given num does not contain any leading zero.
     * Example 1:
     *
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     * Example 2:
     *
     * Input: num = "10200", k = 1
     * Output: "200"
     * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     * Example 3:
     *
     * Input: num = "10", k = 2
     * Output: "0"
     * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     *
     * https://leetcode.com/problems/remove-k-digits/
     */

    public static String removeKDigits(String num, int k) {
        if(num.length() == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for(int j=0; j < k; j++) {
            int i=0;
            while(i < sb.length() -1 && sb.charAt(i) <= sb.charAt(i+1)) {
                i++;
            }

            sb.delete(i, i+1);

            // remove preceeding 0s
            while(sb.length() > 1 && sb.charAt(0) == '0') {
                sb.delete(0,1);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        assert removeKDigits("10", 2).equals("0");
        assert removeKDigits("10200", 1).equals("200");
        assert removeKDigits("1432219", 3).equals("1219");
    }
}
