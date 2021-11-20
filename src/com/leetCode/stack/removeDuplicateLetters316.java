package com.leetCode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class removeDuplicateLetters316 {
    public static void main(String[] args) {
        String s = "ecbacba";
        System.out.println(removeDuplicateLetters(s));

    }

    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        //把string转成char数组
        char[] arr = s.toCharArray();
        //记录每个字母最后出现的位置
        int[] site = new int[26];
        for (int i = 0; i < len; i++) {
            site[arr[i] - 'a'] = i;
        }
        //存储入栈和出栈元素
        Deque<Character> stack = new ArrayDeque<>(len);
        //设置一个boolean数组，得知在栈里面有没有该元素
        boolean[] vist = new boolean[26];

        for (int i = 0; i < len; i++) {
            char cur = arr[i];
            if (vist[cur - 'a']) {
                continue;
            }
            while (!stack.isEmpty() &&
                    stack.peekFirst() > cur &&
                    site[stack.peekFirst() - 'a'] > i) {
                char top = stack.pop();
                vist[top - 'a'] = false;
            }
            stack.push(cur);
            vist[cur - 'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.insert(0,stack.pop());
        }
        return stringBuilder.toString();
    }
}
