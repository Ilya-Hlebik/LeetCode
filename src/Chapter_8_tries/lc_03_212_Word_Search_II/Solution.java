package Chapter_8_tries.lc_03_212_Word_Search_II;

import java.util.*;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        Set<String> result = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (result.size() == words.length){
                    break;
                }
                checkBoard(board, i, j, trie.getRoot(), result, visited);
            }
        }
        return new ArrayList<>(result);
    }

    private void checkBoard(char[][] board, int x, int y, Node root, Set<String> result, Set<Map.Entry<Integer, Integer>> visited) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited.contains(Map.entry(x, y)) || !root.children.containsKey(board[x][y])) {
            return;
        }
        visited.add(Map.entry(x, y));
        char letter = board[x][y];
        root = root.children.get(letter);
        if (root.endOfWord) {
            result.add(root.fullWord);
        }
        checkBoard(board, x - 1, y, root, result, visited);
        checkBoard(board, x, y + 1,root, result, visited);
        checkBoard(board, x + 1, y, root, result, visited);
        checkBoard(board, x, y - 1, root, result, visited);
        visited.remove(Map.entry(x, y));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public Node getRoot() {
        return root;
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node temp = root;
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            if (!temp.children.containsKey(letter)) {
                temp.children.put(letter, new Node());
            }
            temp = temp.children.get(letter);
            if (i == chars.length - 1) {
                temp.endOfWord = true;
                temp.fullWord = word;
            }
        }
    }
}

class Node {
    public Map<Character, Node> children = new HashMap<>();
    public boolean endOfWord;
    public String fullWord;
}
