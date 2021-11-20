package com.leetCode;

public class middleoftheLinkedList876 {
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

        //print(middleNode(listNode1));
        print(middleNode3(listNode1));
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }
    //自己想的最破烂的方法，类似单指针方法
    public static ListNode middleNode(ListNode head){
        int count  = 0;
        int left = 1;
        ListNode node = head;
        while (node != null){
            node = node.next;
            count++;
        }
        int mid = (count - left + 1)/2 + left;
        node = head;
        for (int i = 1; i<mid;i++){
            node = node.next;
        }
        return node;
    }
    //引入快慢指针的概念，是方法一的优化
    //fast != null && fast.next != null这样最后找到的类似
    //mid = (right - left + 1)/2 + left;
    //fast.next != null && fast.next.next != null类似于
    //mid = (right - left)/2 + left;
    public static ListNode middleNode2(ListNode head){
        ListNode low = head,fast = head;
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        return low;

    }
    //引入数组概念
    public static ListNode middleNode3(ListNode head){
        ListNode[] listNodes = new ListNode[100];
        int t = 0;
        while (head != null){
            listNodes[t++] = head;
            head = head.next;
        }
        return listNodes[t/2];
    }
}
