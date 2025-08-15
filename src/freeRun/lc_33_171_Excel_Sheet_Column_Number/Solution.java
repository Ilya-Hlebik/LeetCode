package freeRun.lc_33_171_Excel_Sheet_Column_Number;

public class Solution {
    public int titleToNumber(String columnTitle) {
        char[] charArray = columnTitle.toCharArray();
        int mult = 1;
        int result = 0;
        for (int i = charArray.length-1; i >= 0; i--) {
            result += (charArray[i]-'A'+1) * mult;
            mult*=26;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("ZY"));
    }
}
