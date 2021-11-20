package com.leetCode;

public class addTwoNumbers2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,4,3};
        int[] arr2 = new int[]{5,6,5};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        ListNode l3 = addTwoNumbers(l1,l2);
        System.out.println(l3.toString());
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode dummp = new ListNode(0);
        ListNode p = dummp;
        while (l1 != null || l2 != null || carry > 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            p.next = new ListNode(sum);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            p = p.next;
        }
        return dummp.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        this.val = arr[0];
        ListNode curr = this;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("null");
        return s.toString();
    }
}
