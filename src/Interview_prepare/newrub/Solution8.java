package Interview_prepare.newrub;

public class Solution8 {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        int minSize = Integer.MAX_VALUE;
        for (String str : strs) {
            minSize = Math.min(str.length(), minSize);
        }
        char[] result = new char[minSize];
        boolean isEmpty = true;
        for (String str : strs) {
            if (isEmpty) {
                isEmpty = false;
                for (int i = 0; i < result.length; i++) {
                    result[i] = str.charAt(i);
                }
            }
            for (int i = 0; i < result.length; i++) {
                if (result[i] != str.charAt(i)) {
                    for (int j = i; j < result.length; j++) {
                        result[j] = ' ';
                    }
                }
            }
        }
        return new String(result).trim();
    }
}
