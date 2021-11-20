package com.testSelect;

import java.util.Arrays;

public class insertSelect1 {
    public static void main(String[] args) {
        int[] nums = new int[]{45,21,5,12,6};
        System.out.println(Arrays.toString(insert2(nums)));

    }
    //直接插入
    public static int[] insert(int[] nums){
        for(int i = 1;i<nums.length;i++){
            for(int j = i;j>0;j--){
                if (nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
                }else {
                    break;
                }
            }
        }
        return nums;
    }
    public static void swap(int[] nums,int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
    //设置暂存变量
    public static int[] insert2(int[] nums){
        int len = nums.length;
        for (int i = 1;i<len;i++){
            int tmp = nums[i];
            int j = i;
            while (j > 0&&nums[j - 1]>tmp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }

}
