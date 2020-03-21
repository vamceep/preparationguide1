package preparation.tries;

import java.util.HashMap;

public class Trie {
    String prefix;
    HashMap<Character, Trie> children;
    boolean isWord;

    public Trie(String prefix) {
        this.prefix = prefix;
        children = new HashMap<>();
        isWord = false;
    }
}
