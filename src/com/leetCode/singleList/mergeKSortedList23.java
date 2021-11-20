package com.leetCode.singleList;

import java.util.List;

public class mergeKSortedList23 {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1}, {}, {2}};
        int[] arr2 = new int[]{5, 7};
        ListNode l1 = new ListNode(arr1[0]);
        ListNode l2 = new ListNode(arr1[1]);
        ListNode l3 = new ListNode(arr1[2]);
        ListNode[] list = new ListNode[]{l1,l2,l3};
        //System.out.println(list.toString());
        //System.out.println(l1.toString());
        //System.out.println(mergeKLists(list));
    }
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val ){
                p.next = l1;
                l1=l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2:l1;
        //System.out.println();
        return dummyNode.next;
    }

    public static ListNode mergeKLists(ListNode[] lists,int[] nums) {
       // ListNode dummyNode = new ListNode(0);
      //  ListNode ans = dummyNode;
        ListNode ans = null;
        for(int i = 0;i< lists.length;i++){
            ans = mergeTwoList(ans,lists[i]);
        }

        //return dummyNode.next;
        return ans;
    }
}
