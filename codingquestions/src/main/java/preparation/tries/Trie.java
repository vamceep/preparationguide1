package preparation.tries;

import java.util.HashMap;

public class Trie {
    Character c;
    HashMap<Character, Trie> children;
    boolean isWord;

    public Trie(Character c) {
        this.c = c;
        children = new HashMap<>();
        isWord = false;
    }
}
