package preparation.strings;

public class StringContainingCharsOfOtherString {
    /**
     * Find the smallest window in a string containing all characters of another string
     *
     * Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently.
     *
     * Examples:
     *
     * Input: string = “this is a test string”, pattern = “tist”
     * Output: Minimum window is “t stri”
     * Explanation: “t stri” contains all the characters of pattern.
     *
     *
     *
     * Input: string = “geeksforgeeks”, pattern = “ork”
     * Output: Minimum window is “ksfor”
     *
     * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
     */

    public static final int no_of_chars = 256;
    private static String findSubStringPatten(String str, String pat)
    {
        int strlen = str.length();
        int patlen = pat.length();

        if(strlen < patlen) {
            System.out.println("No such pattern found");
            return "";
        }
        int has_pat[] = new int[no_of_chars];
        for(int i = 0; i < patlen;i++) {
            has_pat[pat.charAt(i)]++;
        }
        // store pattern string chars to hash
        int counter = 0;
        int start = 0;
        int start_index = -1;
        int minLen = Integer.MAX_VALUE;
        int has_str[] = new int[no_of_chars];
        for(int j=0; j< strlen;j++) {
            has_str[str.charAt(j)]++;
            if(has_pat[str.charAt(j)] >= has_str[str.charAt(j)] && has_pat[str.charAt(j)] != 0) {
                counter++;
            }
            if(counter == patlen) {
                while (has_str[str.charAt(start)] > has_pat[str.charAt(start)]
                    ||has_pat[str.charAt(start)] == 0) {
                    if(has_str[str.charAt(start)] > has_pat[str.charAt(start)]) {
                        has_str[str.charAt(start)]--;
                    }
                    start++;
                }
                int window = j - start +1;
                if(minLen > window) {
                    minLen = window;
                    start_index = start;
                }
            }
        }
        if(start_index == -1) {
            return  " ";
        }
        return  str.substring(start_index, start_index +minLen );
    }
    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n " + findSubStringPatten(str, pat));
    }

}
