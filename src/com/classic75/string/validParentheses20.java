package com.classic75.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class validParentheses20 {
    public static void main(String[] args) {
        String s = "(])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Map map = new HashMap();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        LinkedList queue = new LinkedList();
        char[] arr = s.toCharArray();
        for(Character ch : arr){
            if(map.get(ch)!=queue.peekLast()||queue.peekLast()==null){
                queue.addLast(ch);
            }else {
                queue.removeLast();
            }
        }
        return queue.isEmpty();
    }
}
