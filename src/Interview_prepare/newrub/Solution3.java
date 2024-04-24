package Interview_prepare.newrub;

public class Solution3 {
    public boolean backspaceCompare(String s, String t) {
        return modifyString(s).equals(modifyString(t));
    }

    private String modifyString(String s) {
        StringBuilder builder = new StringBuilder();
        int skip = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                skip++;
            } else {
                if (skip != 0) {
                    skip--;
                } else {
                    builder.append(s.charAt(i));
                }
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.backspaceCompare("ab##", "c#d#"));
    }
}
