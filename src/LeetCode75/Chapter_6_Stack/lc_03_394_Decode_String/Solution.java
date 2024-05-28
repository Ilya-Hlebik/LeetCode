package LeetCode75.Chapter_6_Stack.lc_03_394_Decode_String;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c !=']'){
                stack.push(c);
            }
            else {
                StringBuilder builder = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())){
                    builder.append(stack.pop());
                }
                String sub = builder.reverse().toString();
                stack.pop();
                builder = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    builder.append(stack.pop());
                }
                int count = Integer.parseInt(builder.reverse().toString());

                while (count>0){
                    for (char ch: sub.toCharArray()){
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder retv = new StringBuilder();
        while (!stack.isEmpty()){
            retv.append(stack.pop());
        }
        return retv.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a2[c]]"));
    }
}
