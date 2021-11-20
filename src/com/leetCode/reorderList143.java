package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class reorderList143 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        // ListNode listNode6 = new ListNode(3);
        // ListNode listNode7 = new ListNode(0);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        // listNode5.next = listNode6;
        //  listNode6.next = listNode7;

        //reorderList(listNode1);
        System.out.println("----");
        //reorderList2(listNode1);
        reorderList3(listNode1);
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    public static void reorderList(ListNode head) {
        ListNode pre = head;
        ListNode t = pre;
        while (pre != null && pre.next != null) {
            while (t.next.next != null) {
                t = t.next;
            }

            ListNode tail = t.next;
            t.next = null;
            ListNode tmp = pre.next;
            pre.next = tail;
            tail.next = tmp;
            pre = tmp;
            t = pre;

        }
        print(head);
    }

    public static void reorderList2(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            listNodes.add(node);
            node = node.next;
        }
        int i = 0;
        int j = listNodes.size() - 1;
        while (i < j) {
            listNodes.get(i).next = listNodes.get(j);
            i++;
            if (i == j) {
                break;
            }
            listNodes.get(j).next = listNodes.get(i);
            j--;
        }
        listNodes.get(i).next = null;
        print(listNodes.get(0));

    }

    public static void reorderList3(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public static ListNode findMid(ListNode head) {
        ListNode low = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        //ListNode head = l1;
        ListNode tmp1;
        ListNode tmp2;
        while (l1 != null && l2 != null) {
            tmp1 = l1.next;
            tmp2 = l2.next;

            l1.next = l2;
            l1 = tmp1;

            l2.next = l1;
            l2 = tmp2;
        }
        //print(head);
    }
}
