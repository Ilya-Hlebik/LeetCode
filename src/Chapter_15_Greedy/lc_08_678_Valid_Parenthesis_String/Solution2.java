package Chapter_15_Greedy.lc_08_678_Valid_Parenthesis_String;

public class Solution2 {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMax++;
                leftMin++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.checkValidString("(*)("));
    }
}
