package com.leetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class evaluateReversePolishNotation150 {
    public static void main(String[] args) {
        String[]  tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<String> deque = new ArrayDeque();
        for (int i = 0; i < tokens.length; i++) {
            String ch = tokens[i];
            if (ch.equals("+")) {
                int num1 = Integer.parseInt(deque.pollLast());
                int num2 = Integer.parseInt(deque.pollLast());
                deque.addLast(String.valueOf(num1 + num2));
            } else if (ch.equals("-")) {
                int num1 = Integer.parseInt(deque.pollLast());
                int num2 = Integer.parseInt(deque.pollLast());
                deque.addLast(String.valueOf(num1 - num2));
            } else if (ch.equals("*")) {
                int num1 = Integer.parseInt(deque.pollLast());
                int num2 = Integer.parseInt(deque.pollLast());
                deque.addLast(String.valueOf(num1 * num2));
            } else if (ch.equals("/")) {
                int num1 = Integer.parseInt(deque.pollLast());
                int num2 = Integer.parseInt(deque.pollLast());
                deque.addLast(String.valueOf(num2/num1));
            }else {
                deque.addLast(String.valueOf(tokens[i]));
            }
        }
        int i = Integer.parseInt(deque.pollFirst());
        return i;
    }
}

