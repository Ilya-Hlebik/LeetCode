package TopInterview150.Chapter_1_Array_String.lc_23_28_Find_the_Index_of_the_First_Occurrence_in_a_String;

public class Solution {
    public int strStr(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();

        int r = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars1[r++]){
                boolean indexFound = true;
                for (int j = i+1; j < chars.length && r<chars1.length; j++) {
                    if (chars[j] != chars1[r++]){
                        indexFound = false;
                        break;
                    }
                }
                if (indexFound && r == chars1.length){
                    return i;
                }
                else {
                    r = 0;
                }
            }
            else {
                r--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
    }
}
