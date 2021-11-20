package com.leetCode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class minStack155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}

class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> deque;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayDeque<>();
        deque = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.addLast(val);
        deque.addLast(val);
        min = deque.peekFirst();
        if (min >= val) {
            for (int i = 0; i < deque.size() - 1; i++) {
                deque.addLast(deque.removeFirst());
            }
        }
    }

    public void pop() {
        int i = stack.removeLast();
        if (i == deque.peekFirst()) {
            deque.removeFirst();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return deque.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */