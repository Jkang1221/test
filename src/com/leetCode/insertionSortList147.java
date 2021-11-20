package com.leetCode;

public class insertionSortList147 {
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
        print(insertionSortList(listNode1));
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = head.next;
        ListNode lastNode = head;
        //ListNode pre = head;
        while (cur != null){
            if(cur.val < lastNode.val){
                ListNode pre = dummyNode;
                while (pre.next.val < cur.val){
                    pre = pre.next;
                }
                ListNode tmp = pre.next;
                lastNode.next = cur.next;
                cur.next = tmp;
                pre.next = cur;
            }
            lastNode = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }

}
