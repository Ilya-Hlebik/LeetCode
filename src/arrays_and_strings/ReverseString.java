package arrays_and_strings;
/*Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]*/

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        for (int i =s.length-1, j=0; j<i; i--, j++){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h','e','l','l','o'});
    }
}
