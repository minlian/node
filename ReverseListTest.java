package com.minlian.collection.cn.node;

public class ReverseListTest {

    public ListNode reverseList1(ListNode head) {
        //设置虚拟头结点为null值
        ListNode prev = null;
        //设置当前节点为头结点
        ListNode curr = head;
        while (curr != null) {
            //链表当前节点的下一个节点
            ListNode nextTemp = curr.next;
            //反转后的链表的当前节点的下一个节点
            curr.next = prev;
            //链表的虚拟头结点发生位移
            prev = curr;
            //链表的下一个节点位移成为当前节点
            curr = nextTemp;
        }
        //返回链表的虚拟头结点
        return prev;
    }
    public ListNode reverseList2(ListNode head){
        //递归求解的第一部分:求解最基本问题
        //当head等于null或者head.next等于null的时候情况
        if (head == null || head.next == null) return head;
        //递归求解的第二部分；把原问题转化为更小的问题 
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
        ListNode listNode2 = new ReverseListTest().reverseList2(head);
        System.out.println(listNode2);


    }
}
