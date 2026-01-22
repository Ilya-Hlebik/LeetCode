package freeRun.lc_73_306_Additive_Number;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 1, Integer.parseInt(num.substring(0, 1)));
    }

    private boolean dfs(String num, int index, int previous) {
        if (index+1 == num.length()){
            return true;
        }
        while (num.charAt(index) =='0'){
            index++;
        }
        for (int i = index; i < num.length(); i++) {

            int next = Integer.parseInt(num.substring(index, i+1));
            if (num.substring(i+1).startsWith(String.valueOf(previous + next))) {
              return   dfs(num, i+1, next);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("199100199"));
    }
}
