package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class palindromeLinkedList234 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        //ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        //listNode4.next = listNode5;

        System.out.println(isPalindrome(listNode1));

    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left<right){
            if (!(list.get(left).equals(list.get(right)))){
                return false;
            }
            left++;
            right--;
        }
        return true;


    }
}
