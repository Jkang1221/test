package com.leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class degreeArray697 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayList> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                ArrayList temp = hashMap.get(nums[i]);
                temp.add(i);
                hashMap.put(nums[i], temp);
            } else {
                ArrayList t = new ArrayList();
                t.add(i);
                hashMap.put(nums[i], t);
            }
        }
        int maxSize = 0;
        int maxLength = Integer.MAX_VALUE;
        Set<Integer> keys = hashMap.keySet();
        for (Integer i :keys) {
            ArrayList temp = hashMap.get(i);
            if(maxSize<temp.size()){
                maxSize = temp.size();
                int dif = (int) temp.get(temp.size()-1)
                        -(int) temp.get(0);
                maxLength=dif+1;
            }
            if (maxSize == temp.size()){
                int dif = (int) temp.get(temp.size()-1)
                        -(int) temp.get(0);
                maxLength=Math.min(dif+1,maxLength);
            }
        }
        return maxLength;
    }
}
