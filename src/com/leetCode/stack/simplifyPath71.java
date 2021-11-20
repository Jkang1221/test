package com.leetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class simplifyPath71 {
    public static void main(String[] args) {
        String path = "/../a/./b/../..//c/";
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath(path));
    }
}
class Solution71 {
    public String simplifyPath(String path) {
        String[] dirts = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String dirt : dirts) {
            System.out.println(dirt);
            if ("".equals(dirt)||".".equals(dirt)){
                continue;
            }
            if("..".equals(dirt)){
                if(!deque.isEmpty()){
                    deque.removeLast();
                }
                continue;
            }
            deque.addLast(dirt);
            System.out.println(deque);
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(deque.isEmpty()){
            stringBuilder.insert(0,"/");
        }
        while (!deque.isEmpty()){
            stringBuilder.insert(0,deque.removeLast());
            stringBuilder.insert(0,"/");
        }
        return stringBuilder.toString();

    }
}