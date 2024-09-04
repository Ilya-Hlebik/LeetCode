package TopInterview150.Chapter_14_Trie.lc_01_208_Implement_Trie_Prefix_Tree;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {
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

    Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node current = root;
        for (char aChar : chars) {
            if (!current.children.containsKey(aChar)) {
                Node value = new Node();
                current.children.put(aChar, value);
            }
            current = current.children.get(aChar);
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node current = root;
        for (char aChar : chars) {
            if (!current.children.containsKey(aChar)) {
                return false;
            }
            current = current.children.get(aChar);
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node current = root;
        for (char aChar : chars) {
            if (!current.children.containsKey(aChar)) {
                return false;
            }
            current = current.children.get(aChar);
        }
        return true;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean endOfWord;
}
