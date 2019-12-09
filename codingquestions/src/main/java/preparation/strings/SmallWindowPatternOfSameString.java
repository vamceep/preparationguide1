package preparation.strings;

public class SmallWindowPatternOfSameString {
    static final int no_of_chars = 256;
    //find substring with all unique characters present in the string.

    public static void main(String[] args) {
        String str = "faabcbcdbca";
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] visited = new boolean[no_of_chars];
        for(int i=0; i< str.length();i++) {
            if(!visited[str.charAt(i)]) {
                stringBuilder.append(str.charAt(i));
                visited[str.charAt(i)] = true;
            }
        }
        System.out.println("unique chars: " + stringBuilder.toString());
        System.out.println("pattern found: " + SmallWindowPattern.findSubString(str, stringBuilder.toString()));
    }
}
