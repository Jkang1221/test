package com.leetCode.dp;



import java.util.HashSet;
import java.util.List;

public class wordBreak139 {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"cats","dog","sand","and","cat"};


    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < wordDict.size(); i++) {
            hashSet.add(wordDict.get(i));
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }

            }
        }
        return dp[s.length()];
    }
}
