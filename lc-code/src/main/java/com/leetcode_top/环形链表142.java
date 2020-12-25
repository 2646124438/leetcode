package com.leetcode_top;

import com.pojo.ListNode;

public class 环形链表142 {
    // a+(n+1)b+c = 2(a+b) => a = c+(n-1)(b+c)
    //说白了就是快慢指针相遇以后，从head开始，新的ptr指针和slow同时移动相遇时候，就是目标
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            slow = slow.next;
            if(fast.next !=null) {
                fast = fast.next.next;
            }else{
                return null;
            }
            if(slow==fast){
                ListNode curr = head;
                while(curr!=slow){
                    curr = curr.next;
                    slow = slow.next;
                }
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        new 环形链表142().detectCycle(head);
    }
}
