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
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                Node newNode = new Node(c, i == charArray.length - 1);
                current.children.put(c, newNode);
                current = newNode;
            }
        }
        current.terminal = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Node current = node;
        for (char c : charArray) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }
        return current.terminal;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        Node current = node;
        for (char c : charArray) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    char value;
    boolean terminal;

    public Node(char value, boolean terminal) {
        this.   value = value;
        this.terminal = terminal;
    }

    public Node() {
    }
}
