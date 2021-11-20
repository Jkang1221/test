package com.leetCode.stack;

import java.util.*;

public class nextGreaterNodeInLinkedList1019 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 7, 4, 3, 5};
        ListNode l1 = new ListNode(arr1);
        System.out.println(Arrays.toString(nextLargerNodes(l1)));
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Deque<Integer> stack = new ArrayDeque();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peekLast()) < list.get(i)) {
                int top = stack.removeLast();
                result[top] = list.get(i);
            }
            stack.addLast(i);
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }


    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        this.val = arr[0];
        ListNode curr = this;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("null");
        return s.toString();
    }
}