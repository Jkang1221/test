package com.testDaily;

import java.util.ArrayDeque;
import java.util.Deque;

public class test1081 {
    public static void main(String[] args) {
        String s = "ecbacba";
        System.out.println(smallestSubsequence(s));
    }

    public static String smallestSubsequence(String s) {
        char[] array = s.toCharArray();
        int[] site = new int[26];
        for (int i = 0; i < array.length; i++){
            site[array[i] - 'a'] = i;
        }
        boolean[] vist = new boolean[26];
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < array.length; i++){
            char cur = array[i];
            if(vist[cur - 'a']){
                continue;
            }
            while (!deque.isEmpty() && site[deque.peek() - 'a'] > i && deque.peek() > cur  ){
                char top = deque.pop();
                vist[top - 'a'] = false;
            }
            vist[cur - 'a'] = true;
            deque.push(cur);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()){
            stringBuilder.insert(0,deque.pop());
        }
        return stringBuilder.toString();
    }
}
