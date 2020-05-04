package preparation.strings;

import java.util.HashSet;

public class PrintAllSubStringsOfLenM {

    public static void printAllUniqueSubStringsOfLenM(String s, int m) {
        HashSet<String> result = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            for(int j= i;j<=s.length();j++) {
                String susbstr = s.substring(i,j);
                //System.out.println(susbstr);
                if(susbstr.length() >= m) {
                    result.add(susbstr);
                }
            }
        }
        result.stream().forEach(s1 -> System.out.println(s1));
    }
    public static void main(String[] args) {
        String input = "abcabcd";
        int m = 3;
        printAllUniqueSubStringsOfLenM(input, m);
    }
}
