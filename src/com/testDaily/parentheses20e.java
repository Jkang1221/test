package com.testDaily;

import java.util.*;

public class parentheses20e {
    public static void main(String[] args) {
        String s = "{}[()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(']', '[');
            put(')', '(');
            put('}', '{');
        }};
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (deque.isEmpty() || map.get(ch) != deque.peek()) {
                    return false;
                }
                else {
                    deque.pop();
                }
            }else {
                deque.push(ch);
            }
        }
        return deque.isEmpty();
    }
}
