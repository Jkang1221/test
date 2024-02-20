package com.leetCode.singleList;

public class partitionList86 {
  public static void main(String[] args) {

    int[] arr1 = new int[] {1, 4, 3, 2, 5, 2};
    ListNode l1 = new ListNode(arr1);
    int x = 3;
    System.out.println(partition(l1, x));
    // System.out.println(partition2(l1, x).toString());
  }

  public static ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode leftDummy = new ListNode(0);
    ListNode rightDummy = new ListNode(0);
    ListNode leftCur = leftDummy, rightCur = rightDummy;
    while (head != null) {
      if (head.val < x) {
        leftCur.next = head;
        leftCur = leftCur.next;
      } else {
        rightCur.next = head;
        rightCur = rightCur.next;
      }
      head = head.next;
    }
    rightCur.next = null;
    leftCur.next = rightDummy.next;
    return leftDummy.next;
  }
}
