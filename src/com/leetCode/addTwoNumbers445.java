package com.leetCode;

public class addTwoNumbers445 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,4,3};
        int[] arr2 = new int[]{5,6,4};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        //System.out.println(reverse(l1).toString());
        ListNode l3 = addTwoNumbers(l1,l2);
        System.out.println(l3.toString());
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);
        ListNode resultR = addTwo(h1,h2);
        ListNode result = reverse(resultR);
        return result;
    }
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    public static ListNode addTwo(ListNode l1, ListNode l2){
        int carry = 0,sum = 0;
        ListNode dummp = new ListNode(0);
        ListNode p = dummp;
        while (l1 != null || l2!= null || carry >0){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            carry = sum / 10;
            p.next = new ListNode(sum%10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            p = p.next;
        }
        return dummp.next;
    }
}
