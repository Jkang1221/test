package com.leetCode.singleList;

public class removeDuplicatesfromSortedList83 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 2, 3, 3};
        ListNode l1 = new ListNode(arr1);
        System.out.println(deleteDuplicates(l1).toString());
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummyNode.next;
    }
}
