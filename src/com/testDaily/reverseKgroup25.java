package com.testDaily;

import javax.security.auth.kerberos.KerberosKey;

public class reverseKgroup25 {
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
        int k = 3;
        //print(reverseKGroup(listNode1, k));
        print(reverse(listNode1,k));
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    public static ListNode reverse(ListNode head, int k) {
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
            ListNode[] newNode = myReverse(head, tail);
            head = newNode[0];
            tail = newNode[1];
            tail.next = next;
            pre.next = head;
            pre = tail;
            head = tail.next;
        }
        return dummyNode.next;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {

        ListNode p = tail.next;
        ListNode prev = head;
        while (p != tail) {
            ListNode tmp = prev.next;
            prev.next = p;
            p = prev;
            prev = tmp;
        }
        return new ListNode[]{tail, head};
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}