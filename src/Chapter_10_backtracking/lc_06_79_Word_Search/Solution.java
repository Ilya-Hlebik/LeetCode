package Chapter_10_backtracking.lc_06_79_Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int x, int y, int index) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || index > word.length() - 1 || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = ' ';
        boolean found = search(board, word, x - 1, y, index + 1) ||
                search(board, word, x, y + 1, index + 1) ||
                search(board, word, x + 1, y, index + 1) ||
                search(board, word, x, y - 1, index + 1);
        board[x][y] = temp;
        return found;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
         * [["A","B","C","E"],
         * ["S","F","C","S"],
         * ["A","D","E","E"]]
         *
         * */
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }
}
