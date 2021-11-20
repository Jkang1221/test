package com.classic75.string;

import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = new String[]{""};
        System.out.println(groupAnagrams2(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] flag = new boolean[strs.length];
        Arrays.fill(flag, false);
        List<Map<Character, Integer>> calcu = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            calcu.add(calculateTimes(strs[i]));
        }
        for (int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<>();
            if (flag[i]) {
                continue;
            }
            temp.add(strs[i]);
            for (int j = i; j < strs.length; j++) {

                if (j != i && calcu.get(i).equals(calcu.get(j))) {
                    temp.add(strs[j]);
                    flag[j] = true;
                }
            }
            result.add(temp);
        }
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> s1, List<String> s2) {
                return s1.size() - s2.size();
            }
        });
        return result;

    }

    public static Map calculateTimes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
