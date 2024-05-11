package LeetCode75.Chapter_1_Array_String.lc_02_1071_Greatest_Common_Divisor_of_Strings;

public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        String smallest = str1.length() > str2.length() ? str2 : str1;
        String biggest = str1.length() > str2.length() ? str1 : str2;
        for (int i = 0; i < smallest.length(); i++) {
            String current = smallest.substring(0, smallest.length() - i);
            if (biggest.replaceAll(current, "").isEmpty() && smallest.replaceAll(current, "").isEmpty()) {
                return current;
            }
        }
        return "";
    }
}
