package com.leetCode.singleList;

import sun.tools.jstat.Literal;

import java.util.List;

public class partitionList86 {
    public static void main(String[] args) {

        int[] arr1 = new int[]{1,4,3,2,5,2};

        ListNode l1 = new ListNode(arr1);
        int x = 3;
        System.out.println(partition2(l1, x));
        //System.out.println(partition2(l1, x).toString());
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallNode = new ListNode(-1);
        ListNode bigNode = new ListNode(-1);
        ListNode dummyHead = smallNode;
        ListNode tail = bigNode;
        while (head != null) {
            if (head.val < x) {
                smallNode.next = head;
                smallNode = smallNode.next;
            } else {
                bigNode.next = head;
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        bigNode.next = null;
        smallNode.next = tail.next;
        return dummyHead.next;
    }

    public static ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallNode = new ListNode(0);
        ListNode bigNode = new ListNode(0);
        ListNode dummy = smallNode;
        ListNode tail = bigNode;
        while (head != null) {
            if (head.val >= x) {
                bigNode.next = head;
                bigNode = bigNode.next;
            } else {
                smallNode.next = head;
                smallNode = smallNode.next;
            }
            head = head.next;
        }
        bigNode.next = null;
        smallNode.next = tail.next;

        return dummy.next;
    }
}
