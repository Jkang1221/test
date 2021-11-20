package com.leetCode;

import java.awt.event.KeyListener;

public class reverseNodesinkGroup25 {
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
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
        int k = 3;
        print(reverseKGroup(listNode1, k));
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    /*
        public static ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode pre = dummyNode;
            while (head != null) {
                ListNode tail = pre;
                for (int i = 0; i < k; i++) {
                    tail = tail.next;
                    if (tail == null) {
                        return dummyNode.next;
                    }
                }
                ListNode next = tail.next;
                ListNode[] newHead = myReverse(head,tail);
                head = newHead[0];
                tail = newHead[1];
                pre.next = head;
                tail.next = next;
                pre = tail;
                head = tail.next;
            }
            return dummyNode.next;
        }
        public static ListNode[] myReverse(ListNode head,ListNode tail){
            ListNode prev= tail.next;
            ListNode p = head;

            while (prev != tail){
                ListNode next = p.next;
                p.next=prev;
                prev = p;
                p = next;
            }
            return new ListNode[]{tail,head};
        }

     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (head != null) {
            ListNode tail = p;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] newNode = reverse(head,tail);
            head = newNode[0];
            tail = newNode[1];
            p.next = head;
            tail.next = next;
            p = tail;
            head = tail.next;

        }
        return dummy.next;
    }

    public static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }
        return new ListNode[]{tail, head};
    }

}
