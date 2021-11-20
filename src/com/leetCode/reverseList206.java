package com.leetCode;

import java.util.LinkedList;

public class reverseList206 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        listNode1.val = 5;
        listNode1.next = listNode2;
        listNode2.val = 4;
        listNode2.next = listNode3;
        listNode3.val = 3;
        listNode3.next = listNode4;
        listNode4.val = 2;
        //print(listNode1);
        print(reverseList(listNode1));
        }
    public static void print(ListNode node){
        if(node == null ){
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }
    //方式一：
/*    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode  next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }*/
    //方式二：
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList(head.next);
        // head是1，head.next是2，head.next.next = head 就是2指向1，此时链表为 2->1->2
        head.next.next = head;
        // 防止链表循环，1指向null，此时链表为 2->1->null，整个链表为 5->4->3->2->1->null
        head.next = null;
        return newNode;
    }
}

