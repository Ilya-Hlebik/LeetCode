package TopInterview150.Chapter_7_Stack.lc_02_71_Simplify_Path;

import java.util.Stack;

public class Solution2 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int popCount = 0;
        for (int i = path.length() - 1; i >= 0; i--) {
            if (path.charAt(i) != '/') {
                current.append(path.charAt(i));
            } else {
                if (current.toString().equals("..")) {
                    popCount++;
                } else if (current.length() != 0 && !current.toString().equals(".")) {
                    if (popCount == 0) {
                        stack.add(current.reverse().toString());
                    } else {
                        popCount--;
                    }
                }
                current = new StringBuilder();
            }
        }
        StringBuilder result = new StringBuilder("/");
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (stack.size() != 0) {
                result.append("/");
            }
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }
}
