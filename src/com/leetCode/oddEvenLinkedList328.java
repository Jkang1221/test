package com.leetCode;

public class oddEvenLinkedList328 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(7);
        ListNode listNode5 = new ListNode(8);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(0);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        print(oddEvenList(listNode1));
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        int count = 3;
        ListNode evenHead = head.next;
        ListNode oddHead = head;
        ListNode evenPre = evenHead;
        ListNode pre = head;
        head = head.next.next;
        while (head != null) {
            if (count % 2 == 1) {
                oddHead.next = head;
                oddHead = head;

            } else {
                evenHead.next = head;
                evenHead = head;

            }
            if (head.next == null) {
                evenHead.next = null;
            }
            head = head.next;

            count++;
        }
        oddHead.next = evenPre;
        return pre;
    }
}
