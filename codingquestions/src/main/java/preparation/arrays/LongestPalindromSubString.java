package preparation.arrays;

public class LongestPalindromSubString {
    /**
     * Given a string find the longest pallindrom substring
     * O(n2) with O(1) space
     *
     * idea: send and index and check how much it would expand left and right
     * with palindrom constraint
     * send index +1 and check the same
     * check max and update start and end.
     * Repeast till length of the string.
     */

    public static String longestPalindrom(String s) {
        int start = 0; int end = 0;
        for(int i =0; i< s.length();i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if( len > end - start) {
                start = i - (len -1) /2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int expandAroundCenter(String s, int start, int end) {
        int l = start;
        int r = end;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return (r -l -1);
    }

    public static void main(String[] args) {
        String s  = "abcdefghgfebcb";
        System.out.println("palindrom sub string: " + longestPalindrom(s));
    }
}
