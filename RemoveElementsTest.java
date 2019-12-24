package com.minlian.collection.cn.node;

public class RemoveElementsTest {
    /**
     * 使用递归来实现链表的元素删除
     * 明确递归函数本身的语意：
     * 传给递归函数链表的头结点 head和元素 val，
     * 函数本身就是将以我们传来的结点为头结点的链表中所有元素为val的元素删除
     * 可以看做是：头结点+更短的链表（递归解决删除这个更小的链表中的相应的元素）
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode res = removeElements1(head.next, val);
        //如果头结点需要删除，结果为更短的链表的处理结果
        if (head.val == val) {
            return res;
        } else {
            //如果头结点不需要删除，结果为头结点+更短的链表的处理结果
            head.next = res;
            return head;
        }
    }
    //递归删除简化版
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 使用非递归删除
     * @param
     */
    //删除头结点时另做考虑（由于头结点没有前一个结点）
    public ListNode removeElements3(ListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        //头结点等于null值
        if(head == null)
            return head;
        //确保当前结点后还有结点
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                //可能不止一个val，所以prev不能移动，不能使用prev=prev.next
            }
            else
                prev = prev.next;
        }
        //返回head
        return head;
    }
    //简化版
    public ListNode removeElements4(ListNode head, int val) {
        //当head不为空且head的值等于val的时候
        while(head != null && head.val == val)
            head = head.next;
        //当head等于null的时
        if(head == null)
            return head;

        ListNode prev = head;
        //当下一个结点不为空时
        while(prev.next != null){
            //当下一个结点的值等于val时
            if(prev.next.val == val)
                //把待删除的结点跳过
                prev.next = prev.next.next;
            else
                //当前结点向后移动
                prev = prev.next;
        }
        //返回head
        return head;
    }
    //添加一个虚拟头结点，删除头结点就不用另做考虑
    public ListNode removeElements5(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return dummyHead.next;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode listNode1 = new RemoveElementsTest().removeElements1(head, 3);
        System.out.println(listNode1);
    }

}
