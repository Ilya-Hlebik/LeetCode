package freeRun.lc_08_65_Valid_Number;

public class Solution {
    public boolean isNumber(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        boolean exponentWasPresent = false;
        boolean dotWasPresent = false;
        if (chars.length == 1 && !Character.isDigit(chars[0])){
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i]) && chars[i] != 'e' && chars[i] != '.' && chars[i] != '+' && chars[i] != '-') {
                return false;
            }
            if ((chars[i] == '+' || chars[i] == '-') && i > 0 && (chars[i - 1] != 'e' || i == chars.length - 1)) {
                return false;
            }
            if (chars[i] == 'e' && (i == chars.length - 1 || i == 0 || !(i + 1 < chars.length && (Character.isDigit(chars[i + 1]) || chars[i+1] == '+' || chars[i+1] == '-') && (Character.isDigit(chars[i - 1]) || chars[i - 1] == '.')))) {
                return false;
            }
            if (chars[i] == 'e' && !exponentWasPresent) {
                exponentWasPresent = true;
            } else if (chars[i] == 'e') {
                return false;
            }
            if (exponentWasPresent && chars[i] == '.') {
                return false;
            }
            if (chars[i] == '.' && (chars.length == 1 || (i > 0 && (chars[i - 1] == '.' || chars[i - 1] == 'e'))
                    || !(i + 1 < chars.length && Character.isDigit(chars[i + 1]) || (i > 0 && Character.isDigit(chars[i - 1]))))
            ) {
                return false;
            }
            if (chars[i] == '.' && !dotWasPresent) {
                dotWasPresent = true;
            } else if (chars[i] == '.') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Valid numbers (should return true)
        test(solution, "+E3", false);
   /*      test(solution, "0089", true);
        test(solution, "-0.1", true);
        test(solution, "+3.14", true);
        test(solution, "4.", true);
        test(solution, "-.9", true);
        test(solution, "2e10", true);
        test(solution, "-90E3", true);
        test(solution, "3e+7", true);
        test(solution, "+6e-1", true);
        test(solution, "53.5e93", true);
        test(solution, "-123.456e789", true);

        // Invalid numbers (should return false)
        test(solution, "abc", false);
        test(solution, "1a", false);
        test(solution, "1e", false);
        test(solution, "e3", false);
        test(solution, "99e2.5", false);
        test(solution, "--6", false);
        test(solution, "-+3", false);
        test(solution, "95a54e53", false);
        test(solution, "e.", false);
        test(solution, ".e", false);
        test(solution, "..", false);
        test(solution, ".e1", false);
        test(solution, ".1.", false);
        test(solution, "46.e3", true);*/


        System.out.println("All tests completed.");
    }

    private static void test(Solution solution, String input, boolean expected) {
        boolean result = solution.isNumber(input);
        if (result == expected) {
            System.out.println("PASS: \"" + input + "\" -> " + result);
        } else {
            System.out.println("FAIL: \"" + input + "\" -> " + result + " (Expected: " + expected + ")");
        }
    }
}
