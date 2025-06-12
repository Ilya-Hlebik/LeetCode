package freeRun.lc_13_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> result = new HashSet<>();
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            dfs(s, 0, i, result, new ArrayList<>());
        }
        return new ArrayList<>(result);
    }

    public void dfs(String s, int start, int end, Set<String> result, List<Integer> temp) {
        if (temp.size() > 4 || (temp.size() == 4 && start != s.length()) || (temp.size() < 4 && start ==s.length())) {
            return;
        }
        if (start == s.length()) {
            String collect = temp.stream().map(Object::toString).collect(Collectors.joining("."));
            result.add(collect);
        }
        if (end > s.length() || end - start > 1 && s.charAt(start) == '0') {
            return;
        }
        int part = Integer.parseInt(s.substring(start, end));
        if (part <= 255) {
            temp.add(part);
            for (int i = end + 1; i <= end + 3; i++) {
                dfs(s, end, i, result, temp);
            }
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));

    }
}
