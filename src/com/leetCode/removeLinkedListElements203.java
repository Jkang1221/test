package com.leetCode;

public class removeLinkedListElements203 {
    public static void main(String[] args) {
        //LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(7);
        ListNode listNode5 = new ListNode(7);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        int target = 7;
        print(removeElements3(listNode1,target));


    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        node = node.next;
        print(node);
    }
    public static ListNode removeElements(ListNode head,int val){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                while(cur.next!=null&&cur.val == val){
                    cur = cur.next;
                }
                if(cur.next == null && cur.val==val){
                pre.next = null;
                }else {
                    pre.next = cur;
                }

            }
            pre = cur;
            cur=cur.next;
        }
        return dummyNode.next;
    }
    public static ListNode removeElements2(ListNode head,int val){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode tmp = dummyNode;
        if(head == null){
            return head;
        }
        while (tmp.next !=null){
            if(tmp.next.val == val){
                tmp.next=tmp.next.next;
            }else {
                tmp= tmp.next;
            }
        }

        return dummyNode.next;
    }
    public static ListNode removeElements3(ListNode head,int val){
        if(head == null){
            return head;
        }
        head.next = removeElements3(head.next,val);
        return head.val == val ? head.next:head;
    }

}
