package com.leetCode.singleList;

public class linkedListCycle142 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 3, 4, 4, 5};
        ListNode l1 = new ListNode(arr1);
        int pos = 2;
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
        ListNode num = detectCycle(l1);
        int count = 0;
        if (l1 == num){
            System.out.println(count);
        }
        while (l1 != num){
            l1 = l1.next;
            count++;
        }
        System.out.println(count);
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null&& fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next==null){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
