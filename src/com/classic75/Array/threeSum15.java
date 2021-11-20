package com.classic75.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //如果相同跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //left right 相加的值是-nums[i]
            int target = -nums[i];
            //看i之后的有没有结果
            int left = i + 1;
            int right = len - 1;
            while(left<right){
                if (nums[left]+nums[right]>target){
                    right--;
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    //如果相等则跳过
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
