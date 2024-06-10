package TopInterview150.Chapter_1_Array_String.lc_20_14_Longest_Common_Prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder common = new StringBuilder(strs[0]);
        while (common.length() >= 0) {
            boolean founded = true;
            for (String str : strs) {
                if (!str.startsWith(common.toString())) {
                    common.deleteCharAt(common.length() - 1);
                    founded = false;
                    break;
                }
            }
            if (founded) {
                break;
            }
        }
        return common.toString();
    }
}
