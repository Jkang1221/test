package com.leetCode;

public class rotateList61 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
       /* ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);*/
        listNode1.next = listNode2;
/*        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;*/
        int k = 3;
        print(rotateRight(listNode1, k));
        //print(moveOnce(listNode1));
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode pre = head;
        while (pre!=null){
            pre = pre.next;
            count++;
        }
        for (int i = 0; i < k%count; i++) {
            head = moveOnce(head);
        }
        return head;
    }

    public static ListNode moveOnce(ListNode head) {

        ListNode tailPre = head;
        if (head.next.next != null) {
            while (tailPre.next.next != null) {
                tailPre = tailPre.next;
            }
        }
        ListNode tail = tailPre.next;
        tail.next = head;
        tailPre.next = null;
        return tail;

    }
}
