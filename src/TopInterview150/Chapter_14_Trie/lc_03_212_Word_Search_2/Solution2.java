package TopInterview150.Chapter_14_Trie.lc_03_212_Word_Search_2;

import java.util.*;

public class Solution2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        Set<String> result = new HashSet<>();
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, used, trie.root, result);
                if (result.size() == words.length){
                    break;
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int x, int y, boolean[][] used, Node node, Set<String> result) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || used[x][y] || !node.children.containsKey(board[x][y])) {
            return;
        }
        used[x][y] = true;
        Node current = node.children.get(board[x][y]);
        if (current.endOfWord){
            result.add(current.fullWord);
        }
        dfs(board, x - 1, y, used, current, result);
        dfs(board, x, y + 1, used, current, result);
        dfs(board, x + 1, y, used, current, result);
        dfs(board, x, y - 1, used, current, result);
        used[x][y] = false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}
        };
        System.out.println(solution.findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
    }
}

class Trie {
    Node root = new Node();

    public void addWord(String word) {
        Node current = root;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (!current.children.containsKey(aChar)) {
                current.children.put(aChar, new Node());
            }
            current = current.children.get(aChar);
        }
        current.endOfWord = true;
        current.fullWord = word;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    String fullWord;
    boolean endOfWord;
}
