package com.leetCode;

public class reverseLinkedList92 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(7);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        int left = 2;
        int right = 6;
        //print(listNode1);
        //print(reverseBetween(listNode1, left, right));
        print(reverWayTwo(listNode1, left, right));

    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //设置一个虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode curr = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverse(leftNode);
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;

    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverWayTwo(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        /*
        *         ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }*/
        ListNode cur;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            cur = pre.next;
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
        }
        return dummyNode.next;

    }
}
