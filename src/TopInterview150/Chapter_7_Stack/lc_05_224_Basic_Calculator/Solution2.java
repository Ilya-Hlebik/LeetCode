package TopInterview150.Chapter_7_Stack.lc_05_224_Basic_Calculator;

public class Solution2 {
    int idx;

    public int calculate(String s) {
        idx = 0;
        return calc(s);
    }

    private int calc(String s) {
        int num = 0;
        int res = 0;
        int sign = 1;
        while (s.length() > idx) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = calc(s);
            } else if (c == ')') {
                return res + num * sign;
            } else if (c == '+' || c == '-') {
                res += num * sign;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + num * sign;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
