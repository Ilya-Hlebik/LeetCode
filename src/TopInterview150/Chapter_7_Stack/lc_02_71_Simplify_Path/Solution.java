package TopInterview150.Chapter_7_Stack.lc_02_71_Simplify_Path;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                current.append(path.charAt(i));
            }
            if (path.charAt(i) == '/' || i == path.length() - 1) {
                if (current.toString().equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (current.length() != 0 && !current.toString().equals(".") && !current.toString().equals("..")) {
                    stack.add(current.toString());
                }
                current = new StringBuilder();
            }
        }
        StringBuilder result = new StringBuilder("");
        Stack<String> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        temp.add("");
        while (!temp.isEmpty()) {
            result.append(temp.pop());
            if (temp.size() != 0) {
                result.append("/");
            }
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures"));
    }
}
