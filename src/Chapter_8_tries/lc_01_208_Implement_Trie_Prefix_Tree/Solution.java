package Chapter_8_tries.lc_01_208_Implement_Trie_Prefix_Tree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
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
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.children.containsKey(chars[i])) {
                temp.children.put(chars[i], new TrieNode());
            }
            temp = temp.children.get(chars[i]);
            if (i == chars.length - 1) {
                temp.endOfWord = true;
            }
        }
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()){
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {
            if (temp.children.containsKey(chars[i])) {
                temp = temp.children.get(chars[i]);
                if (i == chars.length - 1 && !temp.endOfWord) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()){
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode temp = root;
        for (char aChar : chars) {
            if (temp.children.containsKey(aChar)) {
                temp = temp.children.get(aChar);
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean endOfWord;
}
