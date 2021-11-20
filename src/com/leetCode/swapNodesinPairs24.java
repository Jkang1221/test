package com.leetCode;

public class swapNodesinPairs24 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
/*
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);*/

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
/*        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;*/
        int target = 7;
        print(swapPairs2(listNode1));



    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode dummpNode = new ListNode(-1);
        dummpNode.next = head;
        ListNode pre = dummpNode;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        while (cur != null && cur.next!=null){
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = pre.next;
            if(cur != null&&cur.next != null){
                next = cur.next;
            }
        }
        return dummpNode.next;
    }
    public static ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = head.next;
        head.next = swapPairs2(newNode.next);
        newNode.next = head;
        return newNode;
    }
}
