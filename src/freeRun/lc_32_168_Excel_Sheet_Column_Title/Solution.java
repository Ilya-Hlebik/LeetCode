package freeRun.lc_32_168_Excel_Sheet_Column_Title;

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            int remainder = columnNumber % 26;
            result.append((char)('A' + (remainder == 0 ? 26 : remainder) - 1));
            if (remainder == 0) {
                columnNumber -= 1;
            }
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(52));
    }
}
