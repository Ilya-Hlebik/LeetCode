package freeRun.lc_13_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        Set<String> result = new HashSet<>();
        dfs(s, "", 0, 0, result);
        return new ArrayList<>(result);
    }

    public void dfs(String s, String temp, int index, int dots, Set<String> result) {
        if (dots > 4 || dots == 4 && index < s.length()) {
            return;
        }
        if (dots == 4) {
            result.add(temp);
            return;
        }
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String substring = s.substring(index, i);
            int part = Integer.parseInt(substring);
            if (part <= 255 && !(i - index > 1 && s.charAt(index) == '0')) {
                String optionalDot = dots < 3 ? "." : "";
                dfs(s, temp + substring + optionalDot, i, dots + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.restoreIpAddresses("101023"));

    }
}
