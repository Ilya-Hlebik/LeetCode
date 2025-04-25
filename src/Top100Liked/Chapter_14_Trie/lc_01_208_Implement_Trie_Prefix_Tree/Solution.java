package Top100Liked.Chapter_14_Trie.lc_01_208_Implement_Trie_Prefix_Tree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

    }
}

class Trie {
    Node node = new Node();

    public Trie() {

    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        Node current = node;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!current.children.containsKey(c)) {
                Node newNode = new Node(i == charArray.length - 1);
                current.children.put(c, newNode);
            }
            current = current.children.get(c);
        }
        current.terminal = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Node current = node;
        for (char c : charArray) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.terminal;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        Node current = node;
        for (char c : charArray) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean terminal;

    public Node(boolean terminal) {
        this.terminal = terminal;
    }

    public Node() {
    }
}
