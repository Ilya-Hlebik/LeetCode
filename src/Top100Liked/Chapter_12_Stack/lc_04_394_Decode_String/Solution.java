package Top100Liked.Chapter_12_Stack.lc_04_394_Decode_String;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> value = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c != ']') {
                value.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!value.isEmpty() && Character.isLetter(value.peek())) {
                    sb.insert(0, value.pop());
                }
                String temp = sb.toString();
                sb = new StringBuilder();
                value.pop();
                while (!value.isEmpty() && Character.isDigit(value.peek())) {
                    sb.insert(0, value.pop());
                }
                int count = Integer.parseInt(sb.toString());
                for (int i = 0; i < count; i++) {
                    for (char ch : temp.toCharArray()) {
                        value.push(ch);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!value.isEmpty()) {
            sb.insert(0, value.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }
}
