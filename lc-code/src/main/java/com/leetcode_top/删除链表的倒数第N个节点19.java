package com.leetcode_top;


import com.pojo.ListNode;

public class 删除链表的倒数第N个节点19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode toDelPre = head;
        ListNode toDelNext = head;
        int idx = 0;
        while(curr!=null){
            idx++;
            if(idx>n){
                toDelPre = toDelPre.next;
            }
            if(idx>n-1){
                toDelNext = toDelNext.next;
            }
            curr = curr.next;
        }
        toDelPre.next.next = null;
        toDelPre.next = null;
        toDelPre.next = toDelNext;
        return head;
    }
}
