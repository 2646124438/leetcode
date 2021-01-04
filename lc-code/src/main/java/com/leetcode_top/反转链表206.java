package com.leetcode_top;

import com.pojo.ListNode;

public class 反转链表206 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode curr = head;
        ListNode pre = null;
        while(curr !=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
