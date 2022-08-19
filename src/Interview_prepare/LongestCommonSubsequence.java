package Interview_prepare;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
/*        System.out.println(longestCommonSubsequence.longestCommonSubsequence2("ubmrapg",
                "ezupkr"));*/
/*        System.out.println(longestCommonSubsequence.longestCommonSubsequence2("abcde",
                "ace"));*/
        System.out.println(longestCommonSubsequence.longestCommonSubsequence2("oxcpqrsvwf",
                "shmtulqrypy"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] matrix = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    matrix[i][j] = 1 + matrix[i + 1][j + 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i][j + 1], matrix[i + 1][j]);
                }
            }
        }
        return matrix[0][0];

    }
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] matrix = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                matrix[i][j] = 0;
            }
        }
        int count = 0;
        int coef = -1;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j) && j > coef) {
                    count ++;
                    coef = j;
                    break;
                }
            }
        }

        return count;

    }
}
