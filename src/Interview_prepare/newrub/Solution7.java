package Interview_prepare.newrub;

import java.util.Stack;

public class Solution7 {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        Stack<String> words = new Stack<>();
        StringBuilder builder = new StringBuilder();
        boolean newWord = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                newWord = true;
                builder.append(s.charAt(i));
                if (i == s.length()-1){
                    words.add(builder.toString());
                }
            }
            else {
                if (newWord){
                    newWord = false;
                    words.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
        }
        builder = new StringBuilder();
        while (!words.isEmpty()){
            builder.append(words.pop()).append(" ");
        }
        return builder.toString().trim();
    }
}
