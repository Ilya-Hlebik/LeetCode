package TopInterview150.Chapter_2_Two_Pointers.lc_02_392_Is_Subsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        while (sPointer<s.length() && tPointer<t.length()){
            if (sChars[sPointer] == tChars[tPointer]){
                sPointer++;
                tPointer++;
            }
            else {
                tPointer++;
            }
        }
        return sPointer == s.length();
    }
}
