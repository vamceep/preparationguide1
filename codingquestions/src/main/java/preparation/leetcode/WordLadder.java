package preparation.leetcode;

import java.util.*;

public class WordLadder {
    /**
     * Word Ladder (Length of shortest chain to reach a target word)
     * Last Updated: 25-06-2020
     * Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a valid word i.e., it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
     * Example:
     *
     * Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
     *        start = TOON
     *        target = PLEA
     * Output: 7
     * TOON - POON - POIN - POIE - PLIE - PLEE - PLEA
     *
     * Input: Dictionary = {ABCD, EBAD, EBCD, XYZA}
     *        Start = ABCV
     *        End = EBAD
     * Output: 4
     * ABCV - ABCD - EBCD - EBAD
     * https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
     *
     * https://leetcode.com/problems/word-ladder/
     */

    /**
     * Approach:
     * <p>
     * Start from the given start word.
     * Push the word in the queue
     * Run a loop until the queue is empty
     * Traverse all words that adjacent (differ by one character) to it and push the word in a queue (for BFS)
     * Keep doing so until we find the target word or we have traversed all words.
     * <p>
     * Time complexity: O(n²m), where m is the number of entries originally in the dictionary and n is the size of the string.
     * Auxiliary Space:O(m*n), where m are the strings are stored in queue.
     * So the space Complexity is O(m*n).
     */
    public static int shortestChainLenSet1(String start, String target, Set<String> D) {
        if (!D.contains(target)) {
            return 0;
        }

        int level = 0;
        int wordLength = start.length();

        Queue<String> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            ++level;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                char[] word = q.peek().toCharArray();
                q.remove();
                for (int pos = 0; pos < wordLength; pos++) {
                    char orig_char = word[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[pos] = c;
                        if (String.valueOf(word).equals(target)) {
                            return level + 1;
                        }
                        if (!D.contains(String.valueOf(word))) {
                            continue;
                        }

                        D.remove(String.valueOf(word));

                        q.add(String.valueOf(word));
                    }
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }

    /**
     * Approach: This problem can be solved using the standard BFS approach as discussed here but its performance
     * can be improved by using bi-directional BFS. Bi-directional BFS doesn’t reduce the time complexity of the
     * solution but it definitely optimizes the performance in many cases. This approach can also be used in many
     * other shortest pathfinding problems where we have sufficient information about the source and the target node.
     * The basic idea involved in bi-directional BFS is to start the search from both the ends of the path.
     * Therefore, two queues and two visited arrays are needed to be maintained to track both the paths. So, whenever
     * a node (say A) is present in the source queue, encounters a node (say B) which is present in the target queue,
     * then we can calculate the answer by adding the distance of A from source and the distance of B from target minus
     * 1 (one node is common). This way we can calculate the answer in half the time as compared to the standard
     * BFS approach. This method is also known as the meet-in-the-middle BFS approach.
     * https://www.geeksforgeeks.org/word-ladder-set-2-bi-directional-bfs/?ref=rp
     */
    public static class node {
        String word;
        int len;

        public node(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    public static boolean isAdj(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        if (count == 1)
            return true;
        return false;
    }

    public static int shortestChainLenSet2(String beginWord, String endWord, ArrayList<String> wordList) {
        /* q1 is used to traverse the graph from beginWord
        and q2 is used to traverse the graph from endWord.
        vis1 and vis2 are used to keep track of the
        visited states from respective directions */
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();
        HashMap<String, Integer> vis1 = new HashMap<>();
        HashMap<String, Integer> vis2 = new HashMap<>();

        node start = new node(beginWord, 1);
        node end = new node(endWord, 1);

        vis1.put(beginWord, 1);
        q1.add(start);
        vis2.put(endWord, 1);
        q2.add(end);

        while (q1.size() > 0 && q2.size() > 0) {

            // Fetch the current node
            // from the source queue
            node curr1 = q1.remove();

            // Fetch the current node from
            // the destination queue
            node curr2 = q2.remove();

            // Check all the neighbors of curr1
            for (String s : wordList) {

                // If any one of them is adjacent to curr1
                // and is not present in vis1
                // then push it in the queue
                if (isAdj(curr1.word, s) &&
                        !vis1.containsKey(s)) {

                    node temp = new node(s,
                            curr1.len + 1);
                    q1.add(temp);
                    vis1.put(s, curr1.len + 1);

                    // If temp is the destination node
                    // then return the answer
                    if (temp.word.equals(endWord)) {
                        return temp.len;
                    }

                    // If temp is present in vis2 i.e. distance from
                    // temp and the destination is already calculated
                    if (vis2.containsKey(temp.word)) {
                        return temp.len + vis2.get(temp.word) - 1;
                    }
                }
            }

            // Check all the neighbors of curr2
            for (String s : wordList) {

                // If any one of them is adjacent to curr2
                // and is not present in vis1 then push it in the queue.
                if (isAdj(curr2.word, s) &&
                        !vis2.containsKey(s)) {

                    node temp = new node(s,
                            curr2.len + 1);
                    q2.add(temp);
                    vis2.put(s, curr2.len + 1);

                    // If temp is the destination node
                    // then return the answer
                    if (temp.word.equals(beginWord)) {
                        return temp.len;
                    }

                    // If temp is present in vis1 i.e. distance from
                    // temp and the source is already calculated
                    if (vis1.containsKey(temp.word)) {
                        return temp.len + vis1.get(temp.word) - 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // make dictionary
        Set<String> D = new HashSet<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.println("Length of shortest chain is: " + shortestChainLenSet1(start, target, D));


        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("poon");
        wordList.add("plee");
        wordList.add("same");
        wordList.add("poie");
        wordList.add("plie");
        wordList.add("poin");
        wordList.add("plea");

        System.out.println("Length of shortest chain is: " + shortestChainLenSet2(start, target, wordList));
    }
}
