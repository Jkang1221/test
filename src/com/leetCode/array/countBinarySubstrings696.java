package com.leetCode.array;

import java.util.ArrayList;

public class countBinarySubstrings696 {
    public static void main(String[] args) {
        String s = "00111011";
        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {
        int cur = 0;
        int len = s.length();
        int pre = 0;
        int ans = 0;
        ArrayList res = new ArrayList();
        while (cur < len) {
            int count = 0;
            char c = s.charAt(cur);
            while (cur < len && c == s.charAt(cur)) {
                cur++;
                count++;
            }
            res.add(count);
            ans += Math.min(pre, count);
            pre = count;
        }
        System.out.println(res.toString());
        return ans;
    }
}
