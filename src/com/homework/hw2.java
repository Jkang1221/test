package com.homework;

import java.util.ArrayList;

public class hw2 {
    public static void main(String[] args) {
//        System.out.println(method1(12312312));
    }

    public static int method1(ArrayList<Integer> n) {
        int left = 0;
        int right = 0;
        int cur = 1;
        int res = 0, len = n.size();
        while(right < len){
            if(n.get(right) == 0){
                cur = 1;
                left = right;
            }else {
                cur = n.get(right) * cur;
                right++;
            }
            while(right - left == 3){
                res = Math.max(res,cur);
                cur = cur/n.get(left);
                left++;
            }
        }
        return res;
    }
}