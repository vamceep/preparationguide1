package preparation.recurrsion;

import java.util.ArrayList;

public class PrintAllPermutationsOfString {
    /**
     * Give a string print all Permutations strings.
     */

    public static ArrayList<String> getAllPermutations(String s) {
        int len = s.length();
        ArrayList<String> results = new ArrayList<>();
        if(len == 0) {
            results.add("");
            return results;
        }
        for(int i = 0; i < len; i++) {
            String before = s.substring(0, i);
            String after = s.substring(i+1, len);
            ArrayList<String> partials = getAllPermutations(before + after);

            /* prepend the character to results */
            for(String s1 : partials) {
                results.add((s.charAt(i)) + s1);
            }
        }
        return results;
    }
    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> results = getAllPermutations(s);
        for(String s1 : results) {
            System.out.println(s1);
        }
        System.out.println("Total " + results.size());
    }
}
