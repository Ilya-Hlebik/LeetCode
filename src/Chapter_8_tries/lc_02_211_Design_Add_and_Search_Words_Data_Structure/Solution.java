package Chapter_8_tries.lc_02_211_Design_Add_and_Search_Words_Data_Structure;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
         System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b.")); //Expected false
         System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search(".")); //Expected false*/
    }
}

class WordDictionary {
    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node temp = root;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.children.containsKey(chars[i])) {
                temp.children.put(chars[i], new Node());
            }
            temp = temp.children.get(chars[i]);
            if (i == chars.length - 1) {
                temp.endOfWord = true;
            }
        }
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node temp) {
        char[] chars = word.toCharArray();
        if (chars.length == 0){
            return temp.endOfWord;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                for (Map.Entry<Character, Node> characterNodeEntry : temp.children.entrySet()) {
                    boolean isContains = search(word.substring(i + 1, chars.length), characterNodeEntry.getValue());
                    if (isContains) {
                        return true;
                    }
                }
                return false;
            }
            if (!temp.children.containsKey(chars[i]) || (i == chars.length - 1 && !temp.children.get(chars[i]).endOfWord)) {
                return false;
            }
            temp = temp.children.get(chars[i]);
        }
        return true;
    }
}

class Node {
    public Map<Character, Node> children = new HashMap<>();
    public boolean endOfWord;
}
