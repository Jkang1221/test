package com.leetCode.singleList;

public class mergeTwoSortedList21 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{-9, 3};
        int[] arr2 = new int[]{5, 7};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        ListNode l3 = mergeTwoLists(l1, l2);
        System.out.println(l3.toString());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }
    public ListNode(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            throw new IllegalArgumentException("数组不能为空");
//        }
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