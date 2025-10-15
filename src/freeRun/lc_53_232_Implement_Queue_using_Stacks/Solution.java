package freeRun.lc_53_232_Implement_Queue_using_Stacks;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 5; i++) {
            myQueue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(myQueue.pop());
        }
    }
}

class MyQueue {

    public MyQueue() {

    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2;

    public void push(int x) {
        stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack2.push(x);

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
