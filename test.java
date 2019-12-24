package com.minlian.collection.cn.node;

public class test {

    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4,5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        //使用迭代实现
        /*ListNode listNode1 = new test().reverseList1(head);
        System.out.println(listNode1);*/
        //使用递归实现
        ListNode listNode2 = new test().reverseList2(head);
        System.out.println(listNode2);


    }
}
