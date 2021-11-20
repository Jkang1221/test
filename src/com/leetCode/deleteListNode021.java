package com.leetCode;

public class deleteListNode021 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(0);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        int n = 2;
        print(removeNthFromEnd(listNode1, n));
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode low = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next=low.next.next;
        return dummyNode.next;
    }
}
