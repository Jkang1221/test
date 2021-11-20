package com.leetCode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class implementStackusingQueues225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
    }
}
class MyStack {
    private Deque<Integer> deque;
    /** Initialize your data structure here. */
    public MyStack() {
        deque = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.addLast(x);
        for(int i = 0; i < this.deque.size()-1;i++){
            deque.addLast(deque.removeFirst());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return deque.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return  deque.isEmpty();
    }
}
