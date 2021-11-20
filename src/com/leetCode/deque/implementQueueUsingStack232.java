package com.leetCode.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class implementQueueUsingStack232 {
    public static void main(String[] args) {

    }

}
class MyQueue {
    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        popStack = new ArrayDeque<>();
        pushStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!popStack.isEmpty()){
            return popStack.removeLast();
        }

        while (!pushStack.isEmpty()){
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        if(!popStack.isEmpty()){
            return popStack.peekLast();
        }

        while (!pushStack.isEmpty()){
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}