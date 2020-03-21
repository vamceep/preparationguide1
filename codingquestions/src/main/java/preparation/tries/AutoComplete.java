package preparation.tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AutoComplete {

    public static class Trie {
        String prefix;
        HashMap<Character, Trie> children;
        boolean isWord;

        public Trie(String prefix) {
            this.prefix = prefix;
            children = new HashMap<>();
            isWord = false;
        }
    }

    public static Trie trie;
    public AutoComplete(String[] dict) {
        trie = new Trie("");
        for(String s : dict) insertWord(s);
    }

    public static void insertWord(String s) {
        Trie current = trie;
        for(int i=0; i<s.length();i++) {
            if(!current.children.containsKey(s.charAt(i))){
                current.children.put(s.charAt(i), new Trie(s.substring(0, i+1)));
            }
            current = current.children.get(s.charAt(i));
            if(i == s.length() -1) {
                current.isWord = true;
            }
        }
    }

    public static List<String> getWordsForPrefix(String pre) {
        List<String> result = new LinkedList<>();
        Trie current = trie;
        for( char c : pre.toCharArray()){
            if(current.children.containsKey(c)) {
                current = current.children.get(c);
            }else {
                return result;
            }
        }
        findAllChildren(current, result);
        return result;
    }

    public static void findAllChildren(Trie trie, List<String> result) {
        if(trie.isWord) result.add(trie.prefix);
        for(Character c : trie.children.keySet()) {
            findAllChildren(trie.children.get(c), result);
        }
    }


    public static void main(String[] args) {
        String[] s = {"abc", "acd", "bcd", "def", "a", "aba"};
        AutoComplete a = new AutoComplete(s);

        assert compareArrays((String[])a.getWordsForPrefix("").toArray(new String[6]),
                new String[]{"abc", "acd", "bcd", "def", "a", "aba"}):
        "Empty string";
        assert compareArrays((String[])a.getWordsForPrefix("a").toArray(new String[4]),
                new String[]{"abc", "acd", "a", "aba"}):
                "Single character prefix";
        assert compareArrays((String[])a.getWordsForPrefix("def").toArray(new String[1]),
                new String[]{"def"}):
                "Prefix the length of the string";
        assert compareArrays((String[])a.getWordsForPrefix("abcd").toArray(new String[0]),
                new String[]{}):
                "No results";
        System.out.println("Passed all test cases");

        for(String s1 : a.getWordsForPrefix("ab")) {
            System.out.println(s1);
        }
    }

    private static boolean compareArrays(String[] s1, String[] s2) {
        if (s1.length != s2.length) return false;

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals(s2[i])) return false;
        }
        return true;
    }
}
