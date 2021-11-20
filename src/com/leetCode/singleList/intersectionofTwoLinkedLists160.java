package com.leetCode.singleList;

import java.util.HashSet;

public class intersectionofTwoLinkedLists160 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 9,1,2,4};
        int[] arr2 = new int[]{3};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        //int pos = 2;
        ListNode tail = l2;
        ListNode l1Head = l1;
        while (tail.next != null) {
            tail = tail.next;
            l1 = l1.next;
        }
        tail.next = l1.next;
        System.out.println(getIntersectionNode2(l1Head, l2).val);
    }

    //方法一：哈希表
/*    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> l = new HashSet<>();
        while (headA != null){
            l.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(l.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }*/

    //方法二：遍历得到两个表的长度
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        if (len1 > len2) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        int distinguish = len2 - len1;
        for (int i = 0; i < distinguish; i++) {
            headB = headB.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public static int getLength(ListNode head){
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}
