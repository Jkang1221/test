package com.leetCode;

import java.util.ArrayList;

public class longestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0||strs==null){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < length; i++) {
            prefix=commenTwoString(prefix,strs[i]);
            if (prefix.length()==0){
                break;
            }
        }

        return prefix;
    }
    public static String commenTwoString(String s1, String s2){
        int len = Math.min(s1.length(),s2.length());
        int index = 0;
        while (index<len&&s1.charAt(index)==s2.charAt(index)){
            index++;
        }
        return s1.substring(0,index);
    }
}
