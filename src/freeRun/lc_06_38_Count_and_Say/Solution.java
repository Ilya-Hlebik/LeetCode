package freeRun.lc_06_38_Count_and_Say;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = contact(pair(res));
        }

        return res;
    }

    public List<int[]> pair(String number) {
        char[] chars = number.toCharArray();
        int count = 1;
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length) {
                result.add(new int[]{chars[i - 1] - '0', count});
                break;
            }
            if (chars[i - 1] == chars[i]) {
                count++;
            } else {
                result.add(new int[]{chars[i - 1] - '0', count});
                count = 1;
            }
        }
        return result;
    }

    public String contact(List<int[]> pairs) {
        StringBuilder res = new StringBuilder();
        for (int[] pair : pairs) {
            res.append(pair[1]).append(pair[0]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(4));
    }
}
