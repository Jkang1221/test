package com.leetCode;

public class FindtheDuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        Solution287 solution287 = new Solution287();
        System.out.println(solution287.findDuplicate(nums));
        int s=0;
        for(int i = 0;i<10;i++){
            s=nums[s];
            System.out.println(s);
        }
    }
}

class Solution287 {
    //方法一：二分法
    /*public int findDuplicate(int[] nums) {
        int n = nums.length;
        if (nums.length <= 2) {
            return 1;
        }
        int left = 1;
        int right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int count = 0;
            for (int num: nums) {
                if(num <= mid){
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;

    }*/
    //方法二：快慢指针
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p1 = 0;
        int p2 = fast;
        while (p1 != p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}
