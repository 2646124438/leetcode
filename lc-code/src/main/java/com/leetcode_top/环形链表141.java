package com.leetcode_top;

import com.pojo.ListNode;

public class 环形链表141 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode low = head;
        ListNode quick = head.next.next;
        while(true){
            if(quick==null||quick.next==null){
                return false;
            }
            if(low.val==quick.val){
                return true;
            }
            quick = quick.next.next;
            low = low.next;
        }
    }
}
