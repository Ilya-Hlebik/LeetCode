package TopInterview150.Chapter_14_Trie.lc_03_212_Word_Search_2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean[][] used = new boolean[board.length][board[0].length];
            boolean wasFound = false;
            for (int i = 0; i < board.length; i++) {
                if (wasFound){
                    break;
                }
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(board, word, 0, i, j, used)) {
                        result.add(word);
                        wasFound = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] used) {
        if (index > word.length() - 1) {
            return true;
        }
        char currentChar = word.charAt(index);
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || used[x][y] || currentChar != board[x][y]) {
            return false;
        }
        used[x][y] = true;
        if (dfs(board, word, index + 1, x - 1, y, used) ||
                dfs(board, word, index + 1, x, y + 1, used) ||
                dfs(board, word, index + 1, x + 1, y, used) ||
                dfs(board, word, index + 1, x, y - 1, used)) {
            return true;
        }
        used[x][y] = false;
        return false;
    }
}
