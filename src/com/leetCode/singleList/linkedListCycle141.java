package com.leetCode.singleList;

public class linkedListCycle141 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 3, 4, 4, 5};
        ListNode l1 = new ListNode(arr1);
        int pos = 1;
        ListNode tail = l1;
        ListNode cycleNode = l1;
        while (tail.next != null) {
            tail = tail.next;
        }
        if (pos >= 0) {
            for (int i = 0; i < pos; i++) {
                cycleNode = cycleNode.next;
            }
            tail.next = cycleNode;
        }
        System.out.println(hasCycle(l1));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if(fast == low){
                return true;
            }
        }
        return false;
    }
}
