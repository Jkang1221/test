package com.leetCode.stack;

import java.util.ArrayList;
import java.util.List;

public class removeNthNode19 {
    public static void main(String[] args) {
        int[] head = new int[]{1};
        int n = 1;
        ListNode node = new ListNode(head);
        System.out.println(removeNthFromEnd(node, n));
        //ListNode m = reverse(node);
        //System.out.println(m);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next=head;
        ListNode fast = dummyNode;
        ListNode low = dummyNode;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            low=low.next;
        }
        low.next = low.next.next;
        System.out.println(head);
        return dummyNode.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;

    }
}
