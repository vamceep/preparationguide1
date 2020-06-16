package preparation.strings;

public class ReverseWordsWithFebonacciIndex {

    /**
     *  Given a list of words, reverse the words whose index is a number in Fibonacci series.
     * Eg. "Hello How are you"
     * Reverse words at index 1,1,2,3,5,8 ...
     */

    public static String reverseString(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
    public static void febReverse(String s, String splitter) {
        int f1 = 1;
        int f2 = 1;
        if(s.length() == 0) {
            return;
        }
        StringBuilder result = new StringBuilder();
        String[] tokens = s.split(splitter);
        int c = 0;
        if(tokens.length == 1) {
            result.append(tokens[c++]);
            System.out.println("Reverse: " +result.toString());
            return;
        }
        while(f2 < tokens.length) {
            while(c < f2) {
                result.append(tokens[c++]);
                result.append(splitter);
            }
            result.append(reverseString(tokens[c++]));
            result.append(splitter);
            int next = f1 + f2;
            f1 = f2;
            f2 = next;
        }
        while(c < tokens.length) {
            result.append(tokens[c++]);
            result.append(splitter);
        }
        System.out.println("Reverse: " + result.toString());
    }
    public static void main(String[] args) {
        String s = "Given an list of words, reverse the words whose index";
        System.out.println("Orig: " + s);
        febReverse(s, " ");
    }
}
