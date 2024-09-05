package TopInterview150.Chapter_14_Trie.lc_02_211_Design_Add_and_Search_Words_Data_Structure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}

class WordDictionary {
    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node current = root;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (!current.children.containsKey(aChar)) {
                current.children.put(aChar, new Node());
            }
            current = current.children.get(aChar);
        }
        current.end = true;
    }

    public boolean search(String word) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            int size = queue.size();
            if (aChar == '.') {
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    queue.addAll(poll.children.values());
                }
            } else {
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    if (poll.children.containsKey(aChar)) {
                        queue.add(poll.children.get(aChar));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.end) {
                return true;
            }
        }
        return false;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean end;
}
