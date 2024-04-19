package Chapter_15_Greedy.lc_08_678_Valid_Parenthesis_String;

import java.util.*;

public class Solution {
    public boolean checkValidString(String s) {
        return dfs(s.toCharArray(), 0, new LinkedList<>());
    }
    Map<String, Boolean> memo = new HashMap<>();
    public boolean dfs(char[] s, int index, Queue<Character> queue) {
        String key = index + "|" + Arrays.toString(s) + "|" + queue.toString();

        if (memo.containsKey(key)){
            return memo.get(key);
        }
        for (int i = index; i < s.length; i++) {
            char c = s[i];
            if (c == '_'){
                continue;
            }
            if (c == '(') {
                queue.add(c);
            } else if (c == ')') {
                if (queue.isEmpty()){
                    memo.put(key, false); // Memorize the result
                    return false;
                }
                Character poll = queue.poll();
                if (poll != '(') {
                    memo.put(key, false);
                    return false;
                }
            }
            else {
                s[i] = '(';
                boolean dfs1 = dfs(s, i, new LinkedList<>(queue));
                if (dfs1){
                    memo.put(key, true); // Memorize the result
                    return true;
                }
                s[i] = ')';
                boolean dfs2 = dfs(s, i, new LinkedList<>(queue));
                if (dfs2){
                    memo.put(key, true); // Memorize the result

                    return true;
                }
                s[i] = '_';
                boolean dfs3 = dfs(s, i, new LinkedList<>(queue));
                if (dfs3){
                    memo.put(key, true); // Memorize the result
                    return dfs3;
                }
                s[i] = '*';
            }
        }
        memo.put(key, queue.isEmpty());
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }
}
