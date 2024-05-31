package LeetCode75.Chapter_20_Trie.lc_01_208_Implement_Trie_Prefix_Tree;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            if (!current.children.containsKey(letter)) {
                current.children.put(letter, new TrieNode());
            }
            current = current.children.get(letter);
            if (i == chars.length - 1) {
                current.endWord = true;
            }
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            if (!current.children.containsKey(letter)) {
                return false;
            }
            current = current.children.get(letter);
            if (i == chars.length - 1 && current.endWord) {
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode current = root;
        for (char letter : chars) {
            if (!current.children.containsKey(letter)) {
                return false;
            }
            current = current.children.get(letter);
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endWord;
}
