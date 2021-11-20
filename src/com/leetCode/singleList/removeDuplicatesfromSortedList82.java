package com.leetCode.singleList;

public class removeDuplicatesfromSortedList82 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,3,4,4,5};
        ListNode l1 = new ListNode(arr1);
        System.out.println(deleteDuplicates(l1).toString());
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;
        ListNode cur = head;
        ListNode lastNode = cur.next;
        while (lastNode != null) {
            if (lastNode.val == cur.val) {
                while (lastNode.next != null && lastNode.val == lastNode.next.val) {
                    lastNode = lastNode.next;
                }
                lastNode = lastNode.next;
                cur = lastNode;
                p.next = lastNode;
                if (cur != null) {
                    lastNode = cur.next;
                }
            } else {
                p = cur;
                cur = cur.next;
                lastNode = lastNode.next;
            }
        }
        return dummyNode.next;
    }
}
