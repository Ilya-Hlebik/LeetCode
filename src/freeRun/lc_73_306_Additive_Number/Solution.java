package freeRun.lc_73_306_Additive_Number;

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i < num.length() - 1; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            String first = num.substring(0, i);
            for (int j = i + 1; j < num.length(); j++) {
                String second = num.substring(i, j);
                if (second.length() > 1 && second.charAt(0) == '0') {
                    break;
                }
                BigInteger a = new BigInteger(first);
                BigInteger b = new BigInteger(second);
                for (int index = j; index < num.length(); ) {
                    String sum = String.valueOf(a.add(b));
                    if (num.substring(index).startsWith(sum)) {
                        index += sum.length();
                        if (index == num.length()) {
                            return true;
                        }
                        a = b;
                        b = new BigInteger(sum);
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("999999999999999999999999"));
    }
}
