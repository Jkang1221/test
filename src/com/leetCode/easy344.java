package com.leetCode;

public class easy344 {
}
class Solution {
    public void reverseString(char[] s) {

        for(int left=0,right=s.length-1;left<s.length/2;left++,right--){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;

        }

    }
}