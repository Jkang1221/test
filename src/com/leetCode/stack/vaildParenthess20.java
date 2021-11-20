package com.leetCode.stack;

import java.util.*;

public class vaildParenthess20 {
    public static void main(String[] args) {
        String s = "(]";
        isValid(s);
        System.out.println(isValid2(s));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (deque.isEmpty() || ch != deque.peek()) {
                    return false;
                }
            } else {
                deque.push(ch);
            }
        }

        return deque.isEmpty();
    }

    public static boolean isValid2(String s) {
        Map par = new HashMap();
        Deque res = new ArrayDeque();

        par.put(')', '(');
        par.put('}', '{');
        par.put(']', '[');
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (res.peekLast() == par.get(s.charAt(i)) && res.peekLast() != null) {
                res.removeLast();
            } else {
                res.addLast(s.charAt(i));
            }
        }
        return res.isEmpty();
    }
}