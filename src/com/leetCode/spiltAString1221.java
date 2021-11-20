package com.leetCode;

public class spiltAString1221 {
    public static void main(String[] args) {
        String s = "RLLLLRRRLR";
        Solution1221 solution1221 = new Solution1221();
        System.out.println(solution1221.balancedStringSplit(s));
    }
}

class Solution1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                j++;
            } else {
                j--;
            }
            if (j==0){
                count++;
            }
        }
        return count;
    }
}
