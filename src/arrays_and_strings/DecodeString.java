package arrays_and_strings;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder count = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    count.append(s.charAt(i));
                    i++;
                }
                countStack.push(Integer.parseInt(count.toString()));
            } else if (s.charAt(i) == '[') {
                resStack.push(res.toString());
                res = new StringBuilder();
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                Integer repeatTimes = countStack.pop();
                temp.append(res.toString().repeat(Math.max(0, repeatTimes)));
                res = new StringBuilder(temp.toString());
                i++;
            } else {
                res.append(s.charAt(i++));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]").equals("aaabcbc"));
        System.out.println(decodeString.decodeString("3[a2[c]]").equals("accaccacc"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
        System.out.println(decodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef").equals(
                "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
    }
}
