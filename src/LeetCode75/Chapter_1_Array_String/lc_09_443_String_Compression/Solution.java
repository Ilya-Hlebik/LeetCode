package LeetCode75.Chapter_1_Array_String.lc_09_443_String_Compression;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compress(new char[]{'a', 'b', 'c'}));
    }

    public int compress(char[] chars) {
        char current = chars[0];
        int count = 0;
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != current) {
                compressed.append(current);
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
                current = chars[i];
                if (i == chars.length - 1) {
                    compressed.append(current);
                }
            } else if (i == chars.length - 1) {
                count++;
                compressed.append(current);
                if (count > 1) {
                    compressed.append(count);
                }
            } else {
                count++;
            }
        }
        char[] resultChars = compressed.toString().toCharArray();
        for (int i = 0; i < resultChars.length; i++) {
            chars[i] = resultChars[i];
        }
        return resultChars.length;
    }
}
